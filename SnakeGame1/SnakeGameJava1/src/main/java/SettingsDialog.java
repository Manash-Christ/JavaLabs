import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsDialog extends JDialog {
    private JSlider speedSlider;
    private JCheckBox borderlessCheckbox;
    private JButton applyButton;

    public SettingsDialog(GameFrame parent) {
        super(parent, "Settings", true);
        speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 1000/175);
        borderlessCheckbox = new JCheckBox("Borderless Gameplay", GamePanel.isBorderless);
        applyButton = new JButton("Apply");

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applySettings();
            }
        });

        this.setLayout(new GridLayout(3, 1));
        this.add(speedSlider);
        this.add(borderlessCheckbox);
        this.add(applyButton);

        this.pack();
        setLocationRelativeTo(parent);

    }

    private void applySettings() {
        int newSpeed = speedSlider.getValue();
        boolean newBorderless = borderlessCheckbox.isSelected();
        GamePanel g = new GamePanel();
        g.setDELAY(newSpeed);
        GamePanel.isBorderless = newBorderless;

        // Close the settings dialog
        setVisible(false);
    }
}