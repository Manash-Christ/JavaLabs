import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private SnakeGame snakeGame;

    public MainMenu(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;

        JButton startButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeGame.showGameScreen();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLayout(new BorderLayout());
        add(startButton, BorderLayout.CENTER);
        add(exitButton, BorderLayout.SOUTH);
    }
}
