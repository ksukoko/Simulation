package project.World.creature;

import project.Coordinates;
import project.GameMap;
import project.PathUtils;
import project.World.staticObjects.Grass;

import java.util.Iterator;
import java.util.List;

public class Sheep extends Creature {
    public Sheep(Coordinates coordinates, int health, int speed) {
        super(coordinates, health, speed);
    }

    @Override
    public void eat() {
        health = Math.min(health + 1, maxHealth);
    }

    @Override
    public void makeMove(GameMap gameMap) {
        Iterator<Coordinates> steps = null;
        int stepCounter = 0;
        while (stepCounter < speed){
            if (steps == null) {
                List<Coordinates> way = PathUtils.buildPathToTheEntity(gameMap, getCoordinates(), Grass.class);
                if (way == null) {
                    for (;stepCounter < speed; stepCounter++) {
                        roamAround(gameMap);
                    }
                    return;
                }
                steps = way.iterator();
            }
            if (steps.hasNext()){
               gameMap.moveEntity(getCoordinates(), steps.next());
                stepCounter++;
                if (!steps.hasNext()){
                    eat();
                    steps = null;
                }
            }
        }
    }
}

