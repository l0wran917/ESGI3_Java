package Ant;

import Main.Model;

import java.awt.*;

public class Ant extends Model {

    private boolean hasFood;

    public Ant(Point position) {
        super(position);
        this.view = new AntView(this);
        this.hasFood = false;
    }

    public void move(IAntDeplacement behaviour) {
        behaviour.move(this);
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean getHasFood() {
        return this.hasFood;
    }
}
