package Main;

import Ant.Ant;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

import Ant.Anthill;
import Ant.IAntDeplacement;
import Ant.RandomDeplacement;
import Pheromone.Pheromone;

import Food.Food;

import javax.swing.*;

public class Simulation {
    private LinkedList<Ant> ants;
    private HashMap<Point, Food> food;
    private HashMap<Point, Pheromone> pheromones;
    private Anthill anthill;
    private Random random;

    public Simulation(Dimension windowSize, Point anthillPosition, int antsCount, int foodCount) {
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
        for (Ant ant : this.ants) {
            ant.move(this.anthill);
            checkAntFoundFood(ant);
            displayPheromone(ant);
        }
    }

    private void checkAntFoundFood(Ant ant) {
        Point position = ant.getPosition();
        Food food = this.food.get(position);
        if (food != null) {
            food.removeQty();
            ant.setHasFood(true);
        }
    }

    private void displayPheromone(Ant ant){
        Point position = ant.getPosition();
        if (ant.getHasFood()) {
            Pheromone phero = new Pheromone(position, 10);
            pheromones.put(position, phero);
        }
    }

    private void decreasePheromone() {
        for (Point position: pheromones.keySet()) {
            pheromones.get(position).uncrementDurability();
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
        this.decreasePheromone();
    }
}
