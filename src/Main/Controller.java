package Main;

import Config.ConfigController;

import javax.naming.spi.DirectoryManager;
import java.awt.*;

public class Controller {

    public static void main(String[] args) {
        ConfigController conf = new ConfigController();
    }

    public Controller(Dimension windowsSize, Point anthillPosition, int antsCount, int foodCount) {

        Simulation sim = new Simulation(windowsSize, anthillPosition, antsCount, foodCount);
        Render rend = new Render(windowsSize);
        boolean isRunning = true;

        rend.init(sim);
        while (isRunning) {
            sim.nextStep();
            rend.paint(sim);

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
