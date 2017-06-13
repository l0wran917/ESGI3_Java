package Ant;

import java.awt.*;
import java.util.Random;

public class RandomDeplacement implements IAntDeplacement {

    private Random random;
    private Dimension panel;

    public RandomDeplacement(Dimension panel) {
        this.random = new Random();
        this.panel = panel;
    }

    public void move(Ant ant) {
        Point point = ant.getPosition();
        Point move = new Point(0, 0);
        int direction = random.nextInt(8);

        switch (direction) {
            case 0:
                move.x += 0;
                move.y -= 1;
                break;
            case 1:
                move.x += 1;
                move.y -= 1;
                break;
            case 2:
                move.x += 1;
                move.y += 0;
                break;
            case 3:
                move.x += 1;
                move.y += 1;
                break;
            case 4:
                move.x += 0;
                move.y += 1;
                break;
            case 5:
                move.x -= 1;
                move.y += 1;
                break;
            case 6:
                move.x -= 1;
                move.y += 0;
                break;
            case 7:
                move.x -= 1;
                move.y -= 1;
                break;
        }

        if (point.y + move.y < 0 || point.y + move.y >= panel.getHeight()) {
            move.y *= -1;
        }

        if (point.x + move.x < 0 || point.x + move.x >= panel.getWidth()) {
            move.x *= -1;
        }

        point.x += move.x;
        point.y += move.y;

        ant.setPosition(point);
    }
}
