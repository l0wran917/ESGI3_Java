package Food;

import Ant.Ant;

import javax.swing.*;
import java.awt.*;

public class FoodView extends JPanel {

    private Food food;

    public FoodView(Food food) {
        this.food = food;

        this.setSize(10, 10);
        this.setBackground(new Color(255, 0, 0, 255));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        int alpha = (this.food.getQty() * 255) / this.food.getMaxQty();

        if (alpha > 255) {
            alpha = 255;
        } else if (alpha < 0) {
            alpha = 0;
        }

        this.setBackground(new Color(255, 0, 0, alpha));

        this.setLocation(food.getPosition());
        super.paintComponent(graphics);
    }
}
