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
        if (this.pheromone.getDurability() > 0) {
            int alpha = (this.pheromone.getDurability() * 255) / this.pheromone.getDurability();
            this.pheromone.uncrementDurability();

            if (alpha > 255) {
                alpha = 255;
            } else if (alpha < 0) {
                alpha = 0;
            }
            this.setBackground(new Color(0, 0, 255, alpha));

            this.setLocation(pheromone.getPosition());
            super.paintComponent(graphics);
        }
    }
}
