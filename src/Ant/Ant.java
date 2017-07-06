package Ant;

import Main.Model;

import java.awt.*;
import java.util.ArrayList;

public class Ant extends Model {

    private boolean hasFood;
    private boolean onPheromone;
    private Point oldPosition;
    private IAntDeplacement behaviour;

    public Ant(Point position, Dimension windowSize) {
        super(position);
        this.view = new AntView(this);
        this.hasFood = false;
        this.onPheromone = false;
        this.oldPosition = position;
        this.behaviour = new RandomDeplacement(windowSize);
    }

    public void move(Anthill anthill, ArrayList<Point> positions) {
        behaviour.move(this, anthill, positions);
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean getHasFood() {
        return this.hasFood;
    }

    public void setOnPheromone(boolean onPheromone) {
        this.onPheromone = onPheromone;
    }

    public boolean getOnPheromone() {
        return this.onPheromone;
    }

    public void setOldPosition(Point oldPosition) {
        this.oldPosition = oldPosition;
    }

    public Point getOldPosition() {
        return this.oldPosition;
    }
}
