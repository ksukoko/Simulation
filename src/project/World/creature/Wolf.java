package project.World.creature;

import project.Coordinates;
import project.GameMap;
import project.PathUtils;
import project.World.Entity;

import java.util.Iterator;
import java.util.List;

public class Wolf extends Creature{
    private final int attack;

    public Wolf(Coordinates coordinates, int attack, int speed, int health) {
        super(coordinates,speed, health);
        this.attack = attack ;
    }


    public void makeMove(GameMap gameMap) {
        Iterator<Coordinates> steps = null;
        int stepCounter = 0;
        while (stepCounter < speed){
            if (steps == null) {
                List<Coordinates> way = PathUtils.buildPathToTheEntity(gameMap, getCoordinates(), Sheep.class);
                if (way == null) {
                    for (;stepCounter < speed; stepCounter++) {
                        roamAround(gameMap);
                    }
                    return;
                }
                steps = way.iterator();
            }
            if (steps.hasNext()){
                Coordinates nextCoordinates = steps.next();
                Entity nextEntity = gameMap.getEntityFromCoordinates(nextCoordinates);
                if (nextEntity instanceof Sheep){
                    Sheep sheep = (Sheep) nextEntity;
                    while (sheep.getHealth() > 0 && stepCounter < speed){
                        sheep.setHealth(sheep.getHealth() - attack);
                        stepCounter++;
                    }
                    if (sheep.getHealth() <= 0) {
                        eat();
                        gameMap.moveEntity(getCoordinates(), nextCoordinates);
                        steps = null;
                    }
                } else {
                    gameMap.moveEntity(getCoordinates(),nextCoordinates);
                    stepCounter++;
                }
            }
        }
    }

    @Override
    public void eat() {
        health = Math.min(health + 1, maxHealth);
    }
}
