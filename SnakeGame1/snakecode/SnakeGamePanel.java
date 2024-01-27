import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SnakeGamePanel extends JPanel implements ActionListener {
    private static final int TILE_SIZE = 20;
    private static final int GRID_SIZE = 50;
    private static final int INIT_SNAKE_LENGTH = 3;

    private int[] snakeX;
    private int[] snakeY;
    private int snakeLength;
    private boolean running;
    private int direction; // 0: up, 1: right, 2: down, 3: left

    private int foodX;
    private int foodY;

    private Timer timer;
    private int snakeSpeed;
    private boolean borderless;

    private int score;

    public SnakeGamePanel() {
        snakeX = new int[GRID_SIZE * GRID_SIZE];
        snakeY = new int[GRID_SIZE * GRID_SIZE];
        snakeLength = INIT_SNAKE_LENGTH;
        running = false;
        direction = 1; // Initial direction: right

        foodX = -1;
        foodY = -1;

        snakeSpeed = 5; // Default speed
        timer = new Timer(1000 / snakeSpeed, this);
        
        borderless = false; // Default: not borderless

        score = 0;

        setPreferredSize(new Dimension(GRID_SIZE * TILE_SIZE, GRID_SIZE * TILE_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
    }

    public void startGame() {
        running = true;
        spawnFood();
        timer.start();
    }

    private void spawnFood() {
        Random rand = new Random();
        foodX = rand.nextInt(GRID_SIZE);
        foodY = rand.nextInt(GRID_SIZE);

        // Make sure the food does not overlap with the snake
        while (isFoodOnSnake()) {
            foodX = rand.nextInt(GRID_SIZE);
            foodY = rand.nextInt(GRID_SIZE);
        }
    }

    private boolean isFoodOnSnake() {
        for (int i = 0; i < snakeLength; i++) {
            if (snakeX[i] == foodX && snakeY[i] == foodY) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (running) {
            // Draw snake
            for (int i = 0; i < snakeLength; i++) {
                g.setColor(Color.GREEN);
                g.fillRect(snakeX[i] * TILE_SIZE, snakeY[i] * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }

            // Draw food
            g.setColor(Color.RED);
            g.fillRect(foodX * TILE_SIZE, foodY * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        } else {
            // Display game over message
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 30));
            g.drawString("Game Over", getWidth() / 4, getHeight() / 2);
            g.drawString("Score: " + score, getWidth() / 4, getHeight() / 2 + 40);
            g.drawString("High Score: " + getHighScoreFromDatabase(), getWidth() / 4, getHeight() / 2 + 80);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkCollision();
            checkFood();
            repaint();
        }
    }

    private void move() {
        // Move the snake body
        for (int i = snakeLength - 1; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        // Move the snake head based on the current direction
        switch (direction) {
            case 0: // up
                snakeY[0]--;
                break;
            case 1: // right
                snakeX[0]++;
                break;
            case 2: // down
                snakeY[0]++;
                break;
            case 3: // left
                snakeX[0]--;
                break;
        }

        // Check if the snake has hit the borders (if not borderless)
        if (!borderless) {
            if (snakeX[0] < 0 || snakeX[0] >= GRID_SIZE || snakeY[0] < 0 || snakeY[0] >= GRID_SIZE) {
                handleGameOver();
            }
        }

        // Check if the snake has hit itself
        for (int i = 1; i < snakeLength; i++) {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                handleGameOver();
            }
        }
    }

    private void checkCollision() {
        // Check if the snake head collides with the food
        if (snakeX[0] == foodX && snakeY[0] == foodY) {
            // Increase snake length
            snakeLength++;
            // Spawn new food
            spawnFood();
            // Increase score
            score++;
        }
    }

    private void checkFood() {
        // Check if the snake head has collided with the food
        if (snakeX[0] == foodX && snakeY[0] == foodY) {
            // Increase snake length
            snakeLength++;
            // Spawn new food
            spawnFood();
            // Increase score
            score++;
        }
    }

    private void handleGameOver() {
        stopGame();
        displayGameOverDialog();
        checkAndUpdateHighScore();
    }

    private void stopGame() {
        timer.stop();
        running = false;
    }

    private void displayGameOverDialog() {
        JOptionPane.showMessageDialog(this, "Game Over!\nYour Score: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, "High Score: " + getHighScoreFromDatabase(), "High SCore", JOptionPane.INFORMATION_MESSAGE );
    }

    private void checkAndUpdateHighScore() {
        
        if (score > getHighScoreFromDatabase()) {
            DatabaseManager.saveHighScore("Player", score);
        }
    }

    private int getHighScoreFromDatabase() {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT MAX(score) AS high_score FROM high_scores";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt("high_score");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 in case of an error
    }

    // @Override
    // public void keyPressed(KeyEvent e) {
    //     int key = e.getKeyCode();
    //     System.out.println("key is "+key);
    //     // Update direction based on user input
    //     if ((key == KeyEvent.VK_LEFT) && (direction != 1)) {
    //         direction = 3; // left
    //     } else if ((key == KeyEvent.VK_RIGHT) && (direction != 3)) {
    //         direction = 1; // right
    //     } else if ((key == KeyEvent.VK_UP) && (direction != 2)) {
    //         direction = 0; // up
    //     } else if ((key == KeyEvent.VK_DOWN) && (direction != 0)) {
    //         direction = 2; // down
    //     }
    // }

    // @Override
    // public void keyTyped(KeyEvent e) {
    // }

    // @Override
    // public void keyReleased(KeyEvent e) {
    // }

    public void resetGame() {
        String[] options = { "Restart", "Exit" };
    var selection = JOptionPane.showOptionDialog(null, "Select one:", "SnakGame", 
                                                      0, 3, null, options, options[0]);
    if (selection == 0) {
        startGame();    }
    if (selection == 1) { 
      JOptionPane.showMessageDialog(null, "Okay da.");
    }
    }
    
    public int getSnakeSpeed() {
        return snakeSpeed;
    }

    public boolean isBorderless() {
       return borderless;
    }

    public void setSnakeSpeed(int newSpeed){this.snakeSpeed=newSpeed;}
    
    public void setBorderless(boolean newBorderless){this.borderless=newBorderless;}


   // 0: up, 1: right, 2: down, 3: left
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
           // System.out.println("Manashwy");
            switch(e.getKeyCode()) {
                //System.out.println("afa");

                case KeyEvent.VK_LEFT:
                    if(direction != 1) {
                        direction = 3;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 3) {
                        direction = 1;
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 2) {
                        direction = 0;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 0) {
                        direction = 2;
                    }
                    break;
            }
        }
    }
}


