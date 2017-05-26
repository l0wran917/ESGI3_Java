package Ant;

import javax.swing.*;
import java.awt.*;

public class AntView extends JPanel{

    private Ant ant;

    public AntView(Ant ant){
        this.ant = ant;

        this.setSize(10, 10);
        this.setLocation(ant.getPosition());
        this.setBackground(new Color(129, 226, 142));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        this.setLocation(ant.getPosition());

        graphics.fillOval(0, 0, 10, 10);
        if(ant.getHasFood()){
            graphics.fillOval(2, 2, 6, 6);
        }
    }
}
