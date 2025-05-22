package project.action.spawn;

import project.World.creature.Sheep;
import project.World.staticObjects.Grass;
import project.action.Action;
import project.GameMap;

public class AllSpawnAction implements Action {
    private final GameMap map;

    public AllSpawnAction(GameMap map) {
        this.map = map;
    }

    @Override
    public void execute() {

        if (map.getEntities(Grass.class).isEmpty()){
            new SpawnGrass(map, 2).execute();
        }
        if (map.getEntities(Sheep.class).isEmpty()){
            new SpawnSheep(map, 5).execute();
        }
    }
}
