package Pheromone;

import Main.Model;

import java.awt.*;

public class Pheromone extends Model {
    private int durability;

    public Pheromone(Point position, int durability) {
        super(position);
        this.view = new PheromoneView(this);
        this.durability = durability;
    }

    public void create() {
        this.durability = 10;
    }

    public void uncrementDurability() {
        this.durability = this.durability - 1;
    }
}
