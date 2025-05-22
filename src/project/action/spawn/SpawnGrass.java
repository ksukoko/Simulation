package project.action.spawn;

import project.Coordinates;
import project.EntityFactory;
import project.GameMap;
import project.World.staticObjects.Grass;

public class SpawnGrass extends SpawnAction {

    public SpawnGrass(GameMap map, int spawnRate) {
        super(map, spawnRate);
    }

    @Override
    public Grass spawn(Coordinates coordinates) {
        return EntityFactory.grassCreate(coordinates);
    }
}
