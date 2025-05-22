package project.action.spawn;

import project.Coordinates;
import project.EntityFactory;
import project.GameMap;
import project.World.creature.Wolf;

public class SpawnWolf extends SpawnAction {


    public SpawnWolf(GameMap map, int spawnRate) {
        super(map, spawnRate);
    }

    @Override
    public Wolf spawn(Coordinates coordinates) {
        return EntityFactory.wolfCreate(coordinates);
    }
}
