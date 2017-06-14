package Ant;

import Main.Model;

import java.awt.*;

public class Ant extends Model {

    private boolean hasFood;
    private IAntDeplacement behaviour;

    public Ant(Point position, Dimension windowSize) {
        super(position);
        this.view = new AntView(this);
        this.hasFood = false;
        this.behaviour = new RandomDeplacement(windowSize);
    }

    public void move(Anthill anthill) {
        behaviour.move(this, anthill);
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean getHasFood() {
        return this.hasFood;
    }
}
