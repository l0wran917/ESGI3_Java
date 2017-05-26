import Config.ConfigController;

public class Controller {

    public static void main(String[] args) {
        ConfigController conf = new ConfigController();
        new Controller();
    }

    public Controller() {
        Simulation sim = new Simulation();
        Render rend = new Render();
        boolean isRunning = true;

        while (isRunning) {
            sim.nextStep();
            rend.paint(sim);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
