package Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConfigView extends JFrame implements ActionListener, KeyListener {

    private ConfigController controller;
    private JTextField inputAntCount;
    private JTextField inputFoodCount;
    private JTextField inputAnthillPositionX;
    private JTextField inputAnthillPositionY;
    private JTextField inputSpeed;
    private JTextField inputWindowPositionX;
    private JTextField inputWindowPositionY;

    private JButton startBtn;
    private final String startAction = "start";

    public ConfigView(ConfigController controller) {
        this.controller = controller;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Configuration");
        this.setSize(360, 360);
        this.getContentPane().setBackground(new Color(44, 62, 80));
        this.setLocation(new Point(0, 0));
        this.setResizable(false);

        startBtn = new JButton("Start");
        startBtn.setActionCommand(this.startAction);
        startBtn.addActionListener(this);
        this.add(startBtn, BorderLayout.SOUTH);

        JPanel fieldsPanel;

        fieldsPanel = new JPanel();

        fieldsPanel.setBackground(new Color(44, 62, 80));
        fieldsPanel.setLayout(new GridLayout(10, 1));

        JPanel breakLine = new JPanel(new FlowLayout());
        breakLine.setBackground(new Color(44, 62, 80));

        /* ******************************************************
                             DEBUT LIGNE 1
        ****************************************************** */

        JPanel rowAntAndFoodCountTitle = new JPanel(new BorderLayout());
        rowAntAndFoodCountTitle.setBackground(new Color(44, 62, 80));

        JLabel labelAntCount = new JLabel("<html>" +
                "<b style='color: white;'>Nombre de fourmis & de nourriture</b>" +
                "</html>", JLabel.CENTER);

        rowAntAndFoodCountTitle.add(labelAntCount);

        JPanel rowAntCountInput = new JPanel(new BorderLayout());
        rowAntCountInput.setBackground(new Color(44, 62, 80));
        inputAntCount = new JTextField(14);
        inputAntCount.setHorizontalAlignment(JTextField.CENTER);
        inputAntCount.setText("5");

        inputFoodCount = new JTextField(14);
        inputFoodCount.setHorizontalAlignment(JTextField.CENTER);
        inputFoodCount.setText("10");

        rowAntCountInput.add(inputAntCount, BorderLayout.WEST);
        rowAntCountInput.add(inputFoodCount, BorderLayout.EAST);

        inputAntCount.addKeyListener(this);
        inputFoodCount.addKeyListener(this);

        fieldsPanel.add(rowAntAndFoodCountTitle);
        fieldsPanel.add(rowAntCountInput);

        /* ******************************************************
                              FIN LIGNE 1
        ****************************************************** */

        /* ******************************************************
                             DEBUT LIGNE 2
        ****************************************************** */

        JPanel rowAnthillPosition = new JPanel(new FlowLayout());
        rowAnthillPosition.setBackground(new Color(44, 62, 80));

        JLabel labelAnthillPosition = new JLabel("<html>" +
                "<b style='color: white;'>Fourmillière (x ; y)</b>" +
                "</html>");

        JPanel rowAnthillPositionInput = new JPanel(new FlowLayout(1, 1,1));
        rowAnthillPositionInput.setBackground(new Color(44, 62, 80));
        inputAnthillPositionX = new JTextField(10);
        inputAnthillPositionX.setHorizontalAlignment(JTextField.CENTER);
        inputAnthillPositionX.setText("5");

        inputAnthillPositionY = new JTextField(10);
        inputAnthillPositionY.setHorizontalAlignment(JTextField.CENTER);
        inputAnthillPositionY.setText("5");

        rowAnthillPosition.add(labelAnthillPosition);
        rowAnthillPositionInput.add(inputAnthillPositionX);
        rowAnthillPositionInput.add(inputAnthillPositionY);

        inputAnthillPositionX.addKeyListener(this);
        inputAnthillPositionY.addKeyListener(this);

        fieldsPanel.add(rowAnthillPosition);
        fieldsPanel.add(rowAnthillPositionInput);

        /* ******************************************************
                              FIN LIGNE 2
        ****************************************************** */

        /* ******************************************************
                             DEBUT LIGNE 3
        ****************************************************** */

        JPanel rowSpeedSize = new JPanel(new FlowLayout());
        rowSpeedSize.setBackground(new Color(44, 62, 80));

        JLabel labelSpeedPosition = new JLabel("<html>" +
                "<b style='color: white;'>Vitesse des fourmis</b>" +
                "</html>");

        JPanel rowSpeedPositionInput = new JPanel(new FlowLayout(1, 1,1));
        rowSpeedPositionInput.setBackground(new Color(44, 62, 80));
        inputSpeed = new JTextField(10);
        inputSpeed.setHorizontalAlignment(JTextField.CENTER);
        inputSpeed.setText("10000");

        rowSpeedSize.add(labelSpeedPosition);
        rowSpeedPositionInput.add(inputSpeed);

        inputSpeed.addKeyListener(this);

        fieldsPanel.add(rowSpeedSize);
        fieldsPanel.add(rowSpeedPositionInput);

        /* ******************************************************
                              FIN LIGNE 3
        ****************************************************** */

        /* ******************************************************
                             DEBUT LIGNE 4
        ****************************************************** */

        JPanel rowWindowSize = new JPanel(new FlowLayout());
        rowWindowSize.setBackground(new Color(44, 62, 80));

        JLabel labelWindowPosition = new JLabel("<html>" +
                "<b style='color: white;'>Taille de la fenêtre (largeur ; hauteur)</b>" +
                "</html>");

        JPanel rowWindowPositionInput = new JPanel(new FlowLayout(1, 1,1));
        rowWindowPositionInput.setBackground(new Color(44, 62, 80));
        inputWindowPositionX = new JTextField(10);
        inputWindowPositionX.setHorizontalAlignment(JTextField.CENTER);
        inputWindowPositionX.setText("800");

        inputWindowPositionY = new JTextField(10);
        inputWindowPositionY.setHorizontalAlignment(JTextField.CENTER);
        inputWindowPositionY.setText("500");


        rowWindowSize.add(labelWindowPosition);
        rowWindowPositionInput.add(inputWindowPositionX);
        rowWindowPositionInput.add(inputWindowPositionY);

        inputWindowPositionX.addKeyListener(this);
        inputWindowPositionY.addKeyListener(this);

        fieldsPanel.add(rowWindowSize);
        fieldsPanel.add(rowWindowPositionInput);

        /* ******************************************************
                              FIN LIGNE 4
        ****************************************************** */

        this.add(fieldsPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String action = actionEvent.getActionCommand();

        if (action.equals(this.startAction)) {
            startApp();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            startApp();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    public void startApp() {
        Dimension windowSize = new Dimension(Integer.parseInt(inputWindowPositionX.getText()), Integer.parseInt(inputWindowPositionY.getText()));
        Point anthillPosition = new Point(Integer.parseInt(inputAnthillPositionX.getText()), Integer.parseInt(inputAnthillPositionY.getText()));
        int foodCount = Integer.parseInt(this.inputFoodCount.getText());
        int antsCount = Integer.parseInt(this.inputAntCount.getText());
        int explorationSpeed = Integer.parseInt(this.inputSpeed.getText());

        this.controller.startSimulation(windowSize, anthillPosition, antsCount, foodCount);
        this.startBtn.setEnabled(false);
    }
}
