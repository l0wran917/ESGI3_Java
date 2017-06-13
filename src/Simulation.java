import Ant.Ant;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

import Ant.Anthill;
import Pheromone.Pheromone;

public class Simulation {
    private LinkedList<Ant> ants;
    private HashMap<Point, Pheromone> pheromones;
    private Anthill anthill;

    public Simulation() {
        this.ants = new LinkedList<Ant>();
        this.pheromones = new HashMap<Point, Pheromone>();
        this.anthill = new Anthill();

        // Debug
        this.ants.add(new Ant(new Point(0, 0)));
        Ant ant = new Ant(new Point(10, 10));
        ant.setHasFood(true);
        this.ants.add(ant);
        this.ants.add(new Ant(new Point(20, 20)));
        this.ants.add(new Ant(new Point(30, 30)));
    }

    public HashMap<Point, Pheromone> getPheromones()

    public LinkedList<Ant> getAnts() {
        return ants;
    }

    public void setAnts(LinkedList<Ant> ants) {
        this.ants = ants;
    }

    public Anthill getAnthill() {
        return anthill;
    }

    public void setAnthill(Anthill anthill) {
        this.anthill = anthill;
    }

    public void nextStep() {
        this.moveAnts();
    }

    private void moveAnts(){
        for(Ant ant : this.ants){
            ant.move(1, 0);
        }
    }
}
