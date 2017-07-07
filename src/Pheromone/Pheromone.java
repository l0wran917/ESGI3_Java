package Pheromone;

import Main.Model;

import java.awt.*;

public class Pheromone extends Model {
    private static int defaultDurability = 1000;
    private static int durabilityAdded = 450;
    private int durability;

    public Pheromone(Point position) {
        super(position);
        this.view = new PheromoneView(this);
        this.durability = Pheromone.defaultDurability;
    }

    public void addDurability(){
        if(this.durability < 1250){
            this.durability += Pheromone.durabilityAdded;
        }
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
