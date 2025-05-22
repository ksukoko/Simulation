package project;


import project.action.Action;
import java.util.ArrayList;
import java.util.List;
import project.action.*;
import project.action.spawn.*;

import static java.lang.Thread.sleep;

public class Simulation {
   private final GameMap gameMap;
   private final MapRenderer mapRenderer;
   private final List<Action> listOfActon;
   private final List<Action> turnActionList ;

    public Simulation(GameMap gameMap) {
        this.gameMap = gameMap;
        this.mapRenderer = new MapRenderer();
        this.listOfActon =new ArrayList<>();
        this.turnActionList = new ArrayList<>();
    }

    public void start() {
        createActions();
        spawnEntity();
        while (true) {
            mapRenderer.render(gameMap);
            nextMove();
            System.out.println();
            rest();
        }
    }


    private void createActions() {

        turnActionList.add(new Move(gameMap));
        turnActionList.add(new AllSpawnAction(gameMap));

        listOfActon.add(new SpawnTree(gameMap, 3));
        listOfActon.add(new SpawnSheep(gameMap, 4));
        listOfActon.add(new SpawnWolf(gameMap, 4));
        listOfActon.add(new SpawnGrass(gameMap, 5));
        listOfActon.add(new SpawnRock(gameMap, 3));

    }
    private void nextMove() {
        for (Action turns : turnActionList) {
            turns.execute();
        }
    }

    private void spawnEntity() {
        for (Action inActionLists : listOfActon) {
            inActionLists.execute();
        }
    }


    private static void rest() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
