package Main;

import Config.ConfigController;
import Pheromone.Pheromone;

import javax.naming.spi.DirectoryManager;
import java.awt.*;

public class Controller {

    private Render render;
    private Simulation simulation;

    public static void main(String[] args) {
        ConfigController conf = new ConfigController();
    }

    public Controller(Dimension windowsSize, Point anthillPosition, int antsCount, int foodCount) {

        this.render = new Render(windowsSize);
        this.simulation = new Simulation(windowsSize, anthillPosition, antsCount, foodCount, this);
        boolean isRunning = true;

        render.init(simulation);
        while (isRunning) {
            simulation.nextStep();
            render.paint(simulation);

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addPheromone(Pheromone pheromone){
        this.render.addPheromone(pheromone);
    }

}
