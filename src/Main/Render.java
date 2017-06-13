package Main;

import Ant.Ant;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

import Ant.AntView;
import Ant.Anthill;
import Ant.AnthillView;

import Food.Food;
import Food.FoodView;

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

    public void paint(Simulation sim) {
        this.paintAnts(sim.getAnts());
        this.paintAnthill(sim.getAnthill());
        this.paintFood(sim.getFood());

        this.repaint();
    }

    private void paintAnts(List<Ant> ants) {
        for (Ant ant : ants) {
            JPanel view = ant.getView();
            this.add(view);
        }
    }

    private void paintAnthill(Anthill anthill) {
        JPanel view = anthill.getView();
        this.add(view);
    }

    private void paintFood(HashMap<Point, Food> foodList){

        for (Point position: foodList.keySet()) {
            Food food = foodList.get(position);
            JPanel view = food.getView();
            this.add(view);
        }

    }
}
