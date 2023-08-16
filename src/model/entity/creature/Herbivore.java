package model.entity.creature;

import model.Map;
import model.entity.Coordinates;
import model.entity.Entity;

import java.util.Random;

public class Herbivore extends Creature {
    private static final int speed = Integer.parseInt(conf.getProperty("entities.herbivore.speed"));
    private static final int hp = Integer.parseInt(conf.getProperty("entities.herbivore.hp"));
    private static final String represenation = conf.getProperty("entities.herbivore.representation");

    public Herbivore(Coordinates coordinates) {
        super(coordinates, "\uD83E\uDD93", speed, hp);
    }

    @Override
    public void makeMove() {
        // TODO:
//        Coordinates newCoordinates = coordinates.shift(randomShift(speed));
//        Entity entity = map.getEntity(coordinates);
//
//        map.removeEntity(coordinates);
//        map.addEntity(newCoordinates, entity);
    }

    private CoordinatesShift randomShift(int speed) {
        int randomLatitudeShift = new Random().nextInt(speed + speed) - speed;
        int randomLongitudeShift = new Random().nextInt(speed + speed) - speed;
        return new CoordinatesShift(randomLatitudeShift, randomLongitudeShift);
    }

    // каждое из живых существ умеет двигаться (makeMove)
    // каждое из них умеет проверять, доступно ли ему перейти на какую-то конкретную ячейку
    /*
     * Все животные могут занимать пустые клетки.
     * Все животные не могут занимать клетки, на которых находятся камни и деревья.
     * Все животные не могут покидать границы поля.
     * Травоядные могут занимать клетки, на которых находится трава, но не могут занимать клетки, на которых находятся другие животные.
     * Хищники не могут занимать клетки, где находится трава, и не могут занимать клетки, где находятся другие хищники. Но могут занимать ячейки, где находятся травоядные.
     */


    // Нужно описать общее между всеми классами-наследниками Creature

    // метод, который возвращает все координаты, доступных для перемещения ячеек. Set<Coordinates>
}
