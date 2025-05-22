package project;
import project.World.Entity;
import project.World.creature.Creature;
import project.World.creature.Sheep;
import project.World.creature.Wolf;
import project.World.staticObjects.Grass;
import project.World.staticObjects.Rock;
import project.World.staticObjects.Tree;

public class MapRenderer {

    public void render(GameMap map){
        for (int i = 1; i < map.getMapHeight(); i++) {
            for (int j = 1; j < map.getMapWidth(); j++) {
                Coordinates coordinates = new Coordinates(i, j);
                Entity entity = map.getEntityFromCoordinates(coordinates);
                System.out.print(getSymbolFor(entity));
                if (entity instanceof Creature){
                    System.out.print(((Creature) entity).getHealth());
                }else {
                    System.out.print("");
                }
            }
            System.out.println();
        }
    }

    public String getSymbolFor(Entity entity) {
        return switch (entity) {
            case null -> "\u26ab";
            case Rock rock -> "⛰️";
            case Tree tree -> "🌳";
            case Sheep sheep -> "🐑";
            case Wolf wolf -> "🐺";
            case Grass grass -> "🌿";
            default -> "?";
        };
    }
}
