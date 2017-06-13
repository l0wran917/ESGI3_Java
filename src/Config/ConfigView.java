package Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigView extends JFrame implements ActionListener {

    ConfigController controller;
    JPanel fieldsPanel;

    public final String startAction = "start";

    public ConfigView(ConfigController controller) {
        this.controller = controller;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Configuration");
        this.setSize(360, 360);
        this.setLocation(new Point(0, 0));

        this.setLayout(new BorderLayout());

        JButton startBtn = new JButton("Start");
        startBtn.setActionCommand(this.startAction);
        startBtn.addActionListener(this);
        this.add(startBtn, BorderLayout.SOUTH);

        this.fieldsPanel = new JPanel();
        this.fieldsPanel.setLayout(new GridLayout(4, 1));

        JPanel row = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Nombre de fourmis : ");
        JTextField input = new JTextField(10);

        this.fieldsPanel.add(row);
        row.add(label);
        row.add(input);

        this.add(this.fieldsPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String action = actionEvent.getActionCommand();
        Dimension d = new Dimension(800, 80);
        int nbSourceFood = 1000;
        int nbAnts = 100;
        int explorationSpeed = 1000;

        if (action.equals(this.startAction)) {
            this.controller.startSimulation(d, nbSourceFood, nbAnts, explorationSpeed);
        }
    }
}
