package project.action.spawn;

import project.Coordinates;
import project.GameMap;
import project.World.Entity;
import project.action.Action;

public abstract class SpawnAction implements Action {
    private final GameMap gameMap;
    protected int spawnRate;

    public SpawnAction(GameMap map, int spawnRate) {
        this.gameMap = map;
        this.spawnRate = spawnRate;
    }

    @Override
    public void execute() {
        int rate = 0;
        for (int i = rate; i < spawnRate; i++){
            Coordinates coordinates = gameMap.getRandomCoordinates();
            gameMap.addEntity(coordinates, spawn(coordinates));
        }
    }
    protected abstract Entity spawn(Coordinates coordinates);
}
