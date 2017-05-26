public class Controller {
    public Controller()
    {
        Simulation sim = new Simulation(null, null, null, null);
        Render rend = new Render();
        while (true) {
            sim.nextStep();
            rend.paint(sim);
            try {
                sim.nextStep();
                rend.paint(sim);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
