package Main;

import Ant.Ant;

import java.awt.*;
import java.util.*;

import Ant.Anthill;
import Ant.IAntDeplacement;
import Ant.RandomDeplacement;
import Pheromone.Pheromone;

import Food.Food;

import javax.naming.ldap.Control;
import javax.swing.*;

public class Simulation {
    private Controller controller;

    private LinkedList<Ant> ants;
    private HashMap<Point, Food> food;
    private HashMap<Point, Pheromone> pheromones;
    private Anthill anthill;
    private Random random;

    public Simulation(Dimension windowSize, Point anthillPosition, int antsCount, int foodCount, Controller controller) {
        this.controller = controller;

        this.ants = new LinkedList<Ant>();
        this.food = new HashMap<Point, Food>();
        this.pheromones = new HashMap<Point, Pheromone>();
        this.anthill = new Anthill(anthillPosition);
        this.random = new Random();

        this.initAnts(antsCount, windowSize);
        this.initFood(foodCount, windowSize);
    }

    public void initAnts(int antsCount, Dimension windowSize) {
        for (int i = 0; i < antsCount; i++) {
            Point position = new Point(random.nextInt(windowSize.width), random.nextInt(windowSize.height));
            Ant ant = new Ant(position, windowSize);
            this.ants.add(ant);
        }
    }

    public void initFood(int foodCount, Dimension windowSize) {
        for (int i = 0; i < foodCount; i++) {
            Point position = null;

            do {
                position = new Point(random.nextInt(windowSize.width), random.nextInt(windowSize.height));
            } while (this.food.get(position) != null);

            Food food = new Food(position);
            this.food.put(position, food);
        }
    }

    private void moveAnts() {
        ArrayList<Point> arrayPosition = new ArrayList<>();
        for (Ant ant : this.ants) {
            if (ant.getHasFood()) {
                this.addPheromone(ant.getPosition());
            }

            arrayPosition = this.showDirection(ant);

            ant.move(this.anthill, arrayPosition);
            checkAntFoundFood(ant);
        }
    }

    private ArrayList<Point> showDirection(Ant ant) {
        Point position = ant.getPosition();
        int i, j;
        Point startedPosition = new Point(position);
        ArrayList<Point> arrayPosition = new ArrayList<>();
        for (i = -1; i < 2; i++) {
            for (j = -1; j < 2; j++) {
                position.x += i;
                position.y += j;
                Pheromone pheromone = pheromones.get(position);
                if ((pheromone != null) && (!position.equals(startedPosition)) && (!position.equals(ant.getOldPosition()))) {
                    if (ant.getOnPheromone()) {
                        ant.setOldPosition(startedPosition);
                    }
                    ant.setOnPheromone(true);
                    if (pheromone.getDurability() > 0) {
                        arrayPosition.add(new Point(position));
                    }
                }
                position = new Point(startedPosition);
            }
        }
        return arrayPosition;
    }

    private void checkAntFoundFood(Ant ant) {
        Point position = ant.getPosition();

        Food food = this.food.get(position);
        if (food != null) {
            food.removeQty();
            ant.setHasFood(true);
        }
    }

    private void addPheromone(Point position) {
        Pheromone pheromone = this.pheromones.get(position);
        if (pheromone == null) {
            pheromone = new Pheromone(position);
            this.pheromones.put(position, pheromone);

            this.controller.addPheromone(pheromone);
        } else {
            pheromone.addDurability();
        }
    }

    public HashMap<Point, Pheromone> getPheromones() {
        return this.pheromones;
    }

    public LinkedList<Ant> getAnts() {
        return ants;
    }

    public Anthill getAnthill() {
        return anthill;
    }

    public HashMap<Point, Food> getFood() {
        return this.food;
    }

    public void nextStep() {
        this.moveAnts();
    }
}
