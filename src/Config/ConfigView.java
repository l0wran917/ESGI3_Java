package Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigView extends JFrame implements ActionListener {

    ConfigController controller;
    JPanel fieldsPanel;

    JTextField inputAntCount;
    JTextField inputAnthillPositionX;
    JTextField inputAnthillPositionY;

    JButton startBtn;

    public final String startAction = "start";

    public ConfigView(ConfigController controller) {
        this.controller = controller;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Configuration");
        this.setSize(360, 360);
        this.setLocation(new Point(0, 0));

        this.setLayout(new BorderLayout());

        startBtn = new JButton("Start");
        startBtn.setActionCommand(this.startAction);
        startBtn.addActionListener(this);
        this.add(startBtn, BorderLayout.SOUTH);

        this.fieldsPanel = new JPanel();
        this.fieldsPanel.setLayout(new GridLayout(4, 1));

        JPanel rowAntCount = new JPanel(new FlowLayout());
        JLabel labelAntCount = new JLabel("Nombre de fourmis : ");
        inputAntCount = new JTextField(10);
        inputAntCount.setText("5");
        rowAntCount.add(labelAntCount);
        rowAntCount.add(inputAntCount);
        this.fieldsPanel.add(rowAntCount);

        JPanel rowAnthillPosition = new JPanel(new FlowLayout());
        JLabel labelAnthillPosition = new JLabel("Anthill (x;y) : ");
        inputAnthillPositionX = new JTextField(10);
        inputAnthillPositionX.setText("350");
        inputAnthillPositionY = new JTextField(10);
        inputAnthillPositionY.setText("350");
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
        Point anthillPosition = new Point(Integer.parseInt(inputAnthillPositionX.getText()), Integer.parseInt(inputAnthillPositionY.getText()));
        int foodCount = 50;
        int antsCount = Integer.parseInt(this.inputAntCount.getText());
        int explorationSpeed = 1000;

        if (action.equals(this.startAction)) {
            this.controller.startSimulation(windowSize, anthillPosition, antsCount, foodCount);
            this.startBtn.setEnabled(false);
        }
    }
}
