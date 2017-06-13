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

        JPanel rowAntCount = new JPanel(new FlowLayout());
        JLabel labelAntCount = new JLabel("Nombre de fourmis : ");
        JTextField inputAntCount = new JTextField(10);
        rowAntCount.add(labelAntCount);
        rowAntCount.add(inputAntCount);
        this.fieldsPanel.add(rowAntCount);

        JPanel rowAnthillPosition = new JPanel(new FlowLayout());
        JLabel labelAnthillPosition = new JLabel("Anthill (x;y) : ");
        JTextField inputAnthillPositionX = new JTextField(10);
        JTextField inputAnthillPositionY = new JTextField(10);
        rowAnthillPosition.add(labelAnthillPosition);
        rowAnthillPosition.add(inputAnthillPositionX);
        rowAnthillPosition.add(inputAnthillPositionY);
        this.fieldsPanel.add(rowAnthillPosition);

        this.add(this.fieldsPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String action = actionEvent.getActionCommand();

        Dimension windowSize = new Dimension(800, 600);
        Point anthillPosition = new Point(375, 275);
        int foodCount = 10;
        int antsCount = 5;
        int explorationSpeed = 1000;

        if (action.equals(this.startAction)) {
            this.controller.startSimulation(windowSize, anthillPosition, antsCount, foodCount);
        }
    }
}
