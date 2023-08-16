package model.entity;

public class Rock extends Entity {
    private static final String represenation = conf.getProperty("entities.rocks.representation");
    public Rock(Coordinates coordinates) {
        super(coordinates, "\uD83D\uDDFF ");
    }
}
