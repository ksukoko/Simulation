package project.action;

import project.GameMap;
import project.World.creature.Creature;

import java.util.List;


public class Move implements Action {

    private final GameMap gameMap;
    public Move(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public void execute() {
        List<Creature> creatures = gameMap.getEntities(Creature.class);
        for (Creature creature : creatures) {
            if (creature.getHealth() <= 0){
                continue;
            }
            creature.makeMove(gameMap);
        }
    }
}
