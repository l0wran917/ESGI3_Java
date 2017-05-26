import Ant.Ant;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import Ant.AntView;

public class Render extends JFrame {

    public Render() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setTitle("Simulation");
        this.setSize(800, 800);

        this.setLayout(null);
        this.setLocation(new Point(400, 100));

        this.setVisible(true);
    }

    public void paint(Simulation sim) {
        this.paintAnts(sim.getAnts());
    }

    private void paintAnts(List<Ant> ants) {
        for (Ant ant : ants) {
            AntView view = ant.getView();
            this.add(view);
        }
        this.repaint();
    }
}
