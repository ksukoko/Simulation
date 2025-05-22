package project.World.creature;

import project.Coordinates;
import project.GameMap;
import project.World.Entity;
import project.World.staticObjects.staticObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Creature extends Entity {
    protected int health;
    protected int speed;
    protected final int maxHealth;

    public Creature(Coordinates coordinates, int health, int speed) {
        super(coordinates);
        this.health = health;
        this.speed = speed;
        this.maxHealth = 6;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void makeMove(GameMap gameMap);
    public abstract void eat();

    private Coordinates getRandomNeighbor(GameMap gameMap, Coordinates from) {
        List<Coordinates> neighbours = gameMap.getNeighbours(from);
        List<Coordinates> applicant = new ArrayList<>();

        for (Coordinates neighbour : neighbours) {
            Entity entity = gameMap.getEntityFromCoordinates(neighbour);
            if (!(entity instanceof staticObject || entity instanceof Creature)) {
                applicant.add(neighbour);
            }
        }

        Random random = new Random();
        if (!applicant.isEmpty()) {
            int randomIndex = random.nextInt(applicant.size());
            return applicant.get(randomIndex);
        } else {
            return from;
        }
    }

    protected void roamAround(GameMap map) {
        map.moveEntity(coordinates, getRandomNeighbor(map, coordinates));
    }
}

