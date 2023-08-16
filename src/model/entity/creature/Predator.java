package model.entity.creature;

import model.entity.Coordinates;
import service.PropertiesLoader;

import java.util.Properties;

public class Predator extends Creature {
    private final static int attackPower = Integer.parseInt(conf.getProperty("entities.predator.attackPower"));
    private final static int speed = Integer.parseInt(conf.getProperty("entities.predator.speed"));
    private final static int hp = Integer.parseInt(conf.getProperty("entities.predator.hp"));

    private static String represenation = conf.getProperty("entities.predator.representation");

    public Predator(Coordinates coordinates) {
        super(coordinates, "\uD83E\uDD81", speed, hp);
    }

    @Override
    public void makeMove() {
        System.out.println("Predator moves");
    }
}
