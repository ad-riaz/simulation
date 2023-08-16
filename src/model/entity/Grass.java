package model.entity;

public class Grass extends Entity {

    private static final String represenation = conf.getProperty("entities.grass.representation");

    public Grass(Coordinates coordinates) {
        super(coordinates, "\uD83C\uDF40");
    }
}
