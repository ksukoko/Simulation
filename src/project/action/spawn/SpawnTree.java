package project.action.spawn;

import project.Coordinates;
import project.EntityFactory;
import project.GameMap;
import project.World.staticObjects.Tree;


public class SpawnTree extends SpawnAction {

    public SpawnTree(GameMap map, int spawnRate) {
        super(map, spawnRate);
    }

    @Override
    public Tree spawn(Coordinates coordinates) {
        return EntityFactory.treeCreate(coordinates);
    }
}
