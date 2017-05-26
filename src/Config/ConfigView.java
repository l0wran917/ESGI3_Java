package Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigView extends JFrame implements ActionListener {

    ConfigController controller;

    public final String startAction = "start";

    public ConfigView(ConfigController controller) {
        this.controller = controller;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Configuration");
        this.setSize(360, 360);

        this.setLayout(new BorderLayout());

        JButton startBtn = new JButton("Start");
        startBtn.setActionCommand(this.startAction);
        startBtn.addActionListener(this);

        this.add(startBtn, BorderLayout.SOUTH);

        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent actionEvent) {
        String action = actionEvent.getActionCommand();

        if (action == this.startAction) {
            this.controller.startSimulation();
        }
    }
}
