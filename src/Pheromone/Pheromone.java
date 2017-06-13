package Pheromone;

import java.awt.*;

public class Pheromone {
    private PheromoneView view;
    private int durability;

    public Pheromone(int durability) {
        this.view = new PheromoneView(this);
        this.durability = durability;
    }

    public void create()
    {
        this.durability = 10;
    }

    public void uncrementDurability()
    {
        this.durability = this.durability - 1;
    }
}
