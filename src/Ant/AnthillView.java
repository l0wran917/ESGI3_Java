package Ant;

import javax.swing.*;
import java.awt.*;

public class AnthillView extends JPanel{

    private Anthill anthill;

    public AnthillView(Anthill anthill){
        this.anthill = anthill;

        this.setSize(50, 50);
        this.setLocation(anthill.getPosition());
        this.setBackground(new Color(68, 214, 226));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Point position = new Point(anthill.getPosition());
        position.x -= this.getWidth()/2;
        position.y -= this.getHeight()/2;

        this.setLocation(position);
        super.paintComponent(graphics);
    }
}
