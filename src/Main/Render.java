package Main;

import Ant.Ant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.List;

import Ant.Anthill;

import Food.Food;

public class Render extends JFrame implements WindowListener {

    public Render(Dimension size) {
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

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        //this.
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
