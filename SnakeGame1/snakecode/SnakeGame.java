import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SnakeGame extends JFrame {
    private MainMenu mainMenu;
    private SnakeGamePanel snakeGamePanel;

    public SnakeGame() {
        mainMenu = new MainMenu(this);
        add(mainMenu);

        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Snake Game");
        setFocusable(true);

        createMenuBar();

        setVisible(true);
    }

    public void showGameScreen() {
        getContentPane().removeAll();

        snakeGamePanel = new SnakeGamePanel();
        add(snakeGamePanel);
        revalidate();
        repaint();
        snakeGamePanel.startGame(); // Start the game logic


    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");
        JMenuItem settingsItem = new JMenuItem("Settings");

        settingsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSettingsDialog();
            }
        });

        optionsMenu.add(settingsItem);
        menuBar.add(optionsMenu);
        setJMenuBar(menuBar);
    }

    private void showSettingsDialog() {
        SettingsDialog settingsDialog = new SettingsDialog(this, snakeGamePanel);
        settingsDialog.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeGame());
    }
}
