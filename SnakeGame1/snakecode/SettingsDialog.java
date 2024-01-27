import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsDialog extends JDialog {
    private SnakeGamePanel snakeGamePanel;

    private JSlider speedSlider;
    private JCheckBox borderlessCheckbox;
    private JButton applyButton;

    public SettingsDialog(JFrame parent, SnakeGamePanel snakeGamePanel) {
        super(parent, "Settings", true);
        this.snakeGamePanel = snakeGamePanel;

        speedSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, snakeGamePanel.getSnakeSpeed());
        borderlessCheckbox = new JCheckBox("Borderless Gameplay", snakeGamePanel.isBorderless());
        applyButton = new JButton("Apply");

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applySettings();
            }
        });

        setLayout(new GridLayout(3, 1));
        add(speedSlider);
        add(borderlessCheckbox);
        add(applyButton);

        pack();
        setLocationRelativeTo(parent);
    }

    private void applySettings() {
        int newSpeed = speedSlider.getValue();
        boolean newBorderless = borderlessCheckbox.isSelected();

        snakeGamePanel.setSnakeSpeed(newSpeed);
        snakeGamePanel.setBorderless(newBorderless);

        // Close the settings dialog
        setVisible(false);
    }
}
