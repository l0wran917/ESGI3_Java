package Main;

import Ant.Ant;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import Ant.Anthill;
import Food.Food;
import Pheromone.Pheromone;

public class Render extends JFrame {

    public Render(Dimension size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setTitle("Simulation");
        this.setSize(size.width, size.height);
        this.setPreferredSize(size);
        this.setLayout(null);
        this.setLocation(new Point(400, 100));

        this.setVisible(true);
    }

    public void init(Simulation sim) {
        this.initAnts(sim.getAnts());
        this.initAnthill(sim.getAnthill());
        this.initFood(sim.getFood());

        this.revalidate();
        this.repaint();
    }

    public void paint(Simulation sim){
        this.repaint();
    }

    private void initAnts(List<Ant> ants) {
        for (Ant ant : ants) {
            JPanel view = ant.getView();
            this.add(view);
        }
    }

    private void initAnthill(Anthill anthill) {
        JPanel view = anthill.getView();
        this.add(view);
    }

    private void initFood(HashMap<Point, Food> foodList){

        for (Point position: foodList.keySet()) {
            Food food = foodList.get(position);
            JPanel view = food.getView();
            this.add(view);
        }
    }

    public void addPheromone(Pheromone pheromone){
        this.add(pheromone.getView());
    }

    private void initPheromone(HashMap<Point, Pheromone> pheromoneList) {
        for (Point position: pheromoneList.keySet()) {
            Pheromone pheromone = pheromoneList.get(position);
            JPanel view = pheromone.getView();
            this.add(view);
        }
    }
}
