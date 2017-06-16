package Ant;

import java.awt.*;
import java.util.Random;

public class RandomDeplacement implements IAntDeplacement {

    private Random random;
    private Dimension panel;

    private int oldDirection;

    public RandomDeplacement(Dimension panel) {
        this.random = new Random();
        this.panel = panel;

        this.oldDirection = random.nextInt(8);
    }

    private boolean changeDirection() {
        int rand = random.nextInt(20); // 0 => 20
        int tolerance = 18;

        return (rand > tolerance);
    }

    public void move(Ant ant, Anthill anthill){
        if(ant.getHasFood()){
            goAnthill(ant, anthill);
        }else{
            explore(ant);
        }
    }

    public void goAnthill(Ant ant, Anthill anthill){
        Point destination = anthill.getPosition();
        Point source = ant.getPosition();

        Point move = new Point(0,0);
        move.x = destination.x - source.x;
        move.y = destination.y - source.y;

        int value = Math.abs((move.x * move.x) - (move.y * move.y));
        if(value < 15){
            ant.setHasFood(false);
        }

        if(move.x > 0) {
            move.x = 1;
        }else if(move.x < 0){
            move.x = -1;
        }

        if(move.y > 0) {
            move.y = 1;
        }else if(move.y < 0){
            move.y = -1;
        }

        source.x += move.x;
        source.y += move.y;

        ant.setPosition(source);
    }

    public void explore(Ant ant) {

        int direction = random.nextInt(8);

        if (!changeDirection()) {
            direction = oldDirection;
        }

        Point point = ant.getPosition();
        Point move = new Point(0, 0);

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
            direction = (direction + 4) % 8;
        }

        if (point.x + move.x < 0 || point.x + move.x >= panel.getWidth()) {
            move.x *= -1;
            direction = (direction + 4) % 8;
        }

        point.x += move.x;
        point.y += move.y;

        this.oldDirection = direction;

        ant.setPosition(point);
    }
}

/*
    7    0   1
    6        2
    5    4   3




 */