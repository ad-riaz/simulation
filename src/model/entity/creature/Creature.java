package model.entity.creature;

import model.entity.Coordinates;
import model.entity.Entity;

public abstract class Creature extends Entity {
    public int speed;
    public int hp;

    public Creature(Coordinates coordinates, String representation, int speed, int hp) {
        super(coordinates, representation);
        this.speed = speed;
        this.hp = hp;
    }

    protected abstract void makeMove();

    public boolean isAlive() {
        return hp > 0;
    }
}
