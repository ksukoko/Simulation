package project;

import project.World.Entity;
import project.World.creature.Creature;
import project.World.staticObjects.staticObject;


import java.util.*;

public class PathUtils {

    public static List<Coordinates> buildPathToTheEntity(GameMap gameMap, Coordinates from, Class<? extends Entity> targetEntityClass) {
        Set<Coordinates> visit = new HashSet<>();
        Queue<Coordinates> queue = new ArrayDeque<>();
        Map<Coordinates, Coordinates> parentMap = new HashMap<>(); // Карта для отслеживания родительских координат

        queue.add(from);
        visit.add(from);

        while (!queue.isEmpty()) {
            Coordinates currentCoordinate = queue.poll();
            Entity entity = gameMap.getEntityFromCoordinates(currentCoordinate);

            if (!currentCoordinate.equals(from)) {
                if (targetEntityClass.isInstance(entity)) {
                    return makeRetreat(parentMap, entity);
                }

                if (entity instanceof staticObject || entity instanceof Creature) {
                    continue;
                }
            }

            for (Coordinates neighbor : gameMap.getNeighbours(currentCoordinate)) {
                if (!visit.contains(neighbor)) {
                    visit.add(neighbor);
                    queue.add(neighbor);
                    parentMap.put(neighbor, currentCoordinate);
                }
            }
        }
        return null;
    }

    private static List<Coordinates> makeRetreat(Map<Coordinates, Coordinates> parentMap, Entity entity) {
        Deque<Coordinates> stack = new LinkedList<>();
        Coordinates retreat = entity.getCoordinates();
        while (retreat != null) {
            stack.push(retreat);
            retreat = parentMap.get(retreat);
        }
        stack.pop();
        return (List<Coordinates>) stack;
    }
}
