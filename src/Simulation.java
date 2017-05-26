import java.util.LinkedList;

public class Simulation {
    private World world;
    private LinkedList<Ant> ants;
    private LinkedList<Pheromone> pheromones;
    private Anthill anthill;

    public Simulation(World world, LinkedList<Ant> ants, LinkedList<Pheromone> pheromones, Anthill anthill) {
        this.world = world;
        this.ants = ants;
        this.pheromones = pheromones;
        this.anthill = anthill;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public LinkedList<Ant> getAnts() {
        return ants;
    }

    public void setAnts(LinkedList<Ant> ants) {
        this.ants = ants;
    }

    public LinkedList<Pheromone> getPheromones() {
        return pheromones;
    }

    public void setPheromones(LinkedList<Pheromone> pheromones) {
        this.pheromones = pheromones;
    }

    public Anthill getAnthill() {
        return anthill;
    }

    public void setAnthill(Anthill anthill) {
        this.anthill = anthill;
    }

    public void nextStep()
    {

    }
}
