package project;

import project.World.creature.Sheep;
import project.World.creature.Wolf;
import project.World.staticObjects.Grass;
import project.World.staticObjects.Rock;
import project.World.staticObjects.Tree;

public class EntityFactory {
    public static Grass grassCreate(Coordinates coordinates){
        return new Grass(coordinates);
    }
    public static Rock rockCreate(Coordinates coordinates){
        return new Rock(coordinates);
    }
    public static Tree treeCreate(Coordinates coordinates){
        return new Tree(coordinates);
    }
    public static Sheep sheepCreate(Coordinates coordinates) {
        return new Sheep(coordinates,2, 1);
    }
    public static Wolf wolfCreate(Coordinates coordinates) {
        return new Wolf(coordinates,2, 2, 2);
    }

}