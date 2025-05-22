package project.action.spawn;

import project.Coordinates;
import project.EntityFactory;
import project.GameMap;
import project.World.creature.Sheep;

public class SpawnSheep extends SpawnAction {

    public SpawnSheep(GameMap map, int spawnRate) {
        super(map, spawnRate);
    }

    @Override
    public Sheep spawn(Coordinates coordinates) {
        return EntityFactory.sheepCreate(coordinates);
    }
}
