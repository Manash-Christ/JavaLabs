import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {


    GameFrame() {

        createMenuBar(this);
        this.add(new GamePanel());

        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }
    private static void createMenuBar(GameFrame game) {
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");
        JMenu gameBtn = new JMenu("Game");
        JMenuItem settingsItem = new JMenuItem("Settings");
        JMenuItem pauseItm = new JMenuItem("Pause");
        JMenuItem restartItm = new JMenuItem("Restart");


        settingsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSettingsDialog(game);
            }
        });

        pauseItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pauseGame();
            }
        });

        restartItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                restartGame();
            }
        });

        optionsMenu.add(settingsItem);
        menuBar.add(optionsMenu);
        menuBar.add(gameBtn);
        gameBtn.add(pauseItm);
        gameBtn.add(restartItm);
        game.setJMenuBar(menuBar);
    }

    private static void restartGame() {new GamePanel();}


    private static void pauseGame() {
        GamePanel.paused = !GamePanel.paused;
    }

    private static void showSettingsDialog(GameFrame game) {
        SettingsDialog settingsDialog = new SettingsDialog(game);
        settingsDialog.setVisible(true);
    }


}

