import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverDialog extends JDialog {
    private SnakeGamePanel snakeGamePanel;
    private int currentScore;

    public GameOverDialog(JFrame parent, SnakeGamePanel snakeGamePanel, int currentScore) {
        super(parent, "Game Over", true);
        this.snakeGamePanel = snakeGamePanel;
        this.currentScore = currentScore;

        JLabel scoreLabel = new JLabel("Your Score: " + currentScore);
        JLabel highScoreLabel = new JLabel("High Score: " + DatabaseManager.getHighScore());

        JButton restartButton = new JButton("Restart");
        JButton closeButton = new JButton("Close");

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeDialog();
            }
        });

        setLayout(new GridLayout(3, 2));
        add(scoreLabel);
        add(highScoreLabel);
        add(restartButton);
        add(closeButton);

        pack();
        setLocationRelativeTo(parent);
    }

    private void restartGame() {
        closeDialog();
        snakeGamePanel.resetGame();
        snakeGamePanel.startGame();
    }

    private void closeDialog() {
        setVisible(false);
    }
}
