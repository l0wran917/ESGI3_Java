public class Controller {
    public Controller()
    {
        Simulation sim = new Simulation(null, null, null, null);
        Render rend = new Render();
        while (true) {
            sim.nextStep();
            rend.paint(sim);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
