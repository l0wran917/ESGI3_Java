package Ant;

import Main.Model;

import java.awt.*;

public class Anthill extends Model {

    public Anthill(Point position) {
        super(position);
        this.view = new AnthillView(this);
    }
}
