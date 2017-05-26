package Config;

import javax.swing.*;

public class ConfigController {

    private JFrame window;
    private ConfigModel config;

    public ConfigController() {
        this.window = new ConfigView(this);
        this.config = new ConfigModel();
    }

    public void startSimulation(){
        System.out.println("Start");
    }


}
