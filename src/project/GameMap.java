package project;

import project.World.Entity;

import java.util.*;

public class GameMap {
    private final int mapWidth;
    private final int mapHeight;

    public GameMap(int maxWidth, int maxHeight) {
        this.mapWidth = maxWidth;
        this.mapHeight = maxHeight;
    }

    private final Map<Coordinates, Entity> map = new HashMap<>();

    public boolean isCellEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public void addEntity(Coordinates coordinates, Entity entity) {
        entity.setCoordinates(coordinates);
        map.put(coordinates, entity);
    }

    public Entity getEntityFromCoordinates(Coordinates coordinates){
        return map.get(coordinates);
    }

    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entity = getEntityFromCoordinates(from);
        if (!from.equals(to)) {
            addEntity(to, entity);
            map.remove(from, entity);
        } else {
            addEntity(to, entity);
        }
    }


    public List<Coordinates> getNeighbours(Coordinates currentCoordinates) {
        int x = currentCoordinates.getX(), y = currentCoordinates.getY();
        Coordinates[] Neighbours = new Coordinates[]{
                new Coordinates(y - 1, x),
                new Coordinates(y + 1, x),
                new Coordinates(y, x + 1),
                new Coordinates(y, x - 1)
        };
        List<Coordinates> neighbour = new ArrayList<>();
        for (Coordinates coordinate : Neighbours) {

            if (coordinate.getX() >= 1 && coordinate.getY() >= 1
                    && coordinate.getX() <= mapWidth && coordinate.getY() <= mapHeight) {
                neighbour.add(coordinate);
            }
        }
        return neighbour;
    }

    public Coordinates getRandomCoordinates(){
        if (map.size() >= mapWidth * mapHeight){
            return null;
        }
        while (true){
            int x = (int) (Math.random() * mapWidth + 1);
            int y = (int) (Math.random() * mapHeight + 1);
            Coordinates coordinates = new Coordinates(y, x);
            if (isCellEmpty(coordinates)){
                return coordinates;
            }
        }
    }

    public <T extends Entity> List<T> getEntities(Class<T> entityType) {
        List<T> entities1 = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> entry : map.entrySet()) {
            Entity entity = entry.getValue();
            if (entityType.isInstance(entity)) {
                entities1.add(entityType.cast(entity));
            }
        }
        return entities1;
    }

    public int getMapWidth() {
        return mapWidth;
    }
    public int getMapHeight() {
        return mapHeight;
    }

}
