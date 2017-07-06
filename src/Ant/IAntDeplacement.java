package Ant;

import java.awt.*;
import java.util.ArrayList;

public interface IAntDeplacement {
    public void move(Ant ant, Anthill anthill, ArrayList<Point> positions);
}
