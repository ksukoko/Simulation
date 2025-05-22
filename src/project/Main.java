package project;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(createMap());

        simulation.start();
    }
    public static GameMap createMap() {
        return new GameMap(20, 10);
    }
}