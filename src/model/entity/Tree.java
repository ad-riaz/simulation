package model.entity;

public class Tree extends Entity {
    private static final String represenation = conf.getProperty("entities.trees.representation");
     public Tree(Coordinates coordinates) {
        super(coordinates, "\uD83C\uDF33");
    }
}
