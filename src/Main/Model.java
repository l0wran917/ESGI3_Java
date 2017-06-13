package Main;

import javax.swing.*;
import java.awt.*;

public abstract class Model {
    protected Point position;
    protected JPanel view;

    public Model(Point position){
        this.position = position;
        this.view = new JPanel();
    }

    public Point getPosition(){
        return new Point(this.position);
    }

    public void setPosition(Point position){
        this.position = position;
    }

    public JPanel getView(){
        return this.view;
    }
}
