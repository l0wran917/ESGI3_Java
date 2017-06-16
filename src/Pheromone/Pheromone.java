package Pheromone;

import Main.Model;

import java.awt.*;

public class Pheromone extends Model {
    private static int defaultDurability = 2000;
    private int durability;

    public Pheromone(Point position) {
        super(position);
        this.view = new PheromoneView(this);
        this.durability = Pheromone.defaultDurability;
    }

    public void create() {
        this.durability = 10;
    }

    public void addDurability(){
        this.durability += Pheromone.defaultDurability;
    }

    public void uncrementDurability() {
        if (this.durability > 0) {
            this.durability = this.durability - 1;
        }
    }

    public int getDurability() {
        return durability;
    }
}
