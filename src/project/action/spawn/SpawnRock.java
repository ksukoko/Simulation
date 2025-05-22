package project.action.spawn;

import project.Coordinates;
import project.EntityFactory;
import project.GameMap;
import project.World.staticObjects.Rock;

public class SpawnRock extends SpawnAction {

    public SpawnRock(GameMap map, int spawnRate) {
        super(map, spawnRate);
    }

    @Override
    public Rock spawn(Coordinates coordinates) {
        return EntityFactory.rockCreate(coordinates);
    }
}
