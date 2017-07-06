package Main;

import Config.ConfigController;
import Pheromone.Pheromone;

import javax.naming.spi.DirectoryManager;
import java.awt.*;

public class Controller {

    private boolean isRunning;

    private Render render;
    private Simulation simulation;

    public static void main(String[] args) {
        ConfigController conf = new ConfigController();
    }

    public Controller(Dimension windowsSize, Point anthillPosition, int antsCount, int foodCount, int explorationSpeed) {

        this.render = new Render(windowsSize, this);
        this.simulation = new Simulation(windowsSize, anthillPosition, antsCount, foodCount, this);
        this.isRunning = true;

        render.init(simulation);
        while (this.isRunning) {
            simulation.nextStep();
            render.paint(simulation);

            try {
                Thread.sleep(100-explorationSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addPheromone(Pheromone pheromone) {
        this.render.addPheromone(pheromone);
    }

    public void stop() {
        this.isRunning = false;
    }

}
