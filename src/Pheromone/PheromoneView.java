package Pheromone;

import javax.swing.*;
import java.awt.*;

public class PheromoneView extends JPanel {

    private Pheromone pheromone;

    public PheromoneView(Pheromone pheromone) {
        this.pheromone = pheromone;

        this.setSize(1, 1);
        this.setBackground(new Color(0, 255, 0, 255));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        int alpha = (this.pheromone.getDurability() * 255) / this.pheromone.getDurability();
        this.pheromone.uncrementDurability();

        if (alpha > 255) {
            alpha = 255;
        } else if (alpha < 0) {
            alpha = 0;
        }
        System.out.println(1);
        this.setBackground(new Color(255, 0, 0, alpha));

        this.setLocation(pheromone.getPosition());
        super.paintComponent(graphics);
    }
}
