package Config;

import Main.Controller;

import javax.swing.*;
import java.awt.*;

public class ConfigController {

    private JFrame window;
    private ConfigModel config;

    public ConfigController() {
        this.window = new ConfigView(this);
        this.config = new ConfigModel();
    }

    public void startSimulation(Dimension windowsSize, Point antihillPosition, int antsCount, int foodCount, int explorationSpeed) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Controller(windowsSize, antihillPosition, antsCount, foodCount, explorationSpeed);
            }
        }).start();
    }


}
