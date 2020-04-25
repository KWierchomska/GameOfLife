import java.io.IOException;

public class Main {

    public static void main(String [] args) {
        Map map = new Map();
        Simulation simulation = new Simulation(map);
        simulation.startSimulation();
    }
}
