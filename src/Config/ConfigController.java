package Config;

import javax.swing.*;
import java.awt.*;

public class ConfigController {

    private JFrame window;
    private ConfigModel config;

    public ConfigController() {
        this.window = new ConfigView(this);
        this.config = new ConfigModel();
    }

    public void startSimulation(Dimension d, int nbSourceFood, int nbAnts, int explorationSpeed) {
        new Simulation(d, nbSourceFood, nbAnts, explorationSpeed);
        //System.out.println(d + " " + nbSourceFood + " " + nbAnts + " " + explorationSpeed);
    }


}
