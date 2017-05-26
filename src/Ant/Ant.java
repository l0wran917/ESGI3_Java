package Ant;

import java.awt.*;

public class Ant {

    private Point position;
    private AntView view;
    private boolean hasFood;

    public Ant(Point position) {
        this.position = position;
        this.view = new AntView(this);
        this.hasFood = false;
    }

    public void move(int x, int y) {
        this.position.x += x;
        this.position.y += y;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean getHasFood() {
        return this.hasFood;
    }

    public AntView getView() {
        return this.view;
    }

    public Point getPosition() {
        return this.position;
    }
}
