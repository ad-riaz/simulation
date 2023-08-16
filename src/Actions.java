import model.Map;
import model.entity.*;
import model.entity.creature.Herbivore;
import model.entity.creature.Predator;
import service.PropertiesLoader;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Random;

public class Actions {

    static Properties conf = PropertiesLoader.loadProperties();
    private static int grassCount = Integer.parseInt(conf.getProperty("entities.grass.count.percentage")) * Map.width * Map.height / 100;
    private static int rocksCount = Integer.parseInt(conf.getProperty("entities.rocks.count.percentage")) * Map.width * Map.height / 100;
    private static int treesCount = Integer.parseInt(conf.getProperty("entities.trees.count.percentage")) * Map.width * Map.height / 100;
    private static int herbivoresCount = Integer.parseInt(conf.getProperty("entities.herbivores.count.percentage")) * Map.width * Map.height / 100;
    private static int predatorsCount = Integer.parseInt(conf.getProperty("entities.predators.count.percentage")) * Map.width * Map.height / 100;

    public static void initActions(Map map) {
        try {
            initEntities(map, grassCount, Grass.class);
            initEntities(map, rocksCount, Rock.class);
            initEntities(map, treesCount, Tree.class);
            initEntities(map, herbivoresCount, Herbivore.class);
            initEntities(map, predatorsCount, Predator.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void turnActions(Map map) {
        //TODO:
    }

    private static <T extends Entity> void initEntities(Map map, int entitiesCount, Class<T> clazz)
    throws  NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        for (int i = 0; i < entitiesCount; i++) {
            boolean isCellEmpty = false;
            do {
                int latitude = new Random().nextInt(map.height);
                int longitude = new Random().nextInt(map.width);
                Coordinates coordinates = new Coordinates(latitude, longitude);

                if (map.isCellEmpty(coordinates)) {
                    isCellEmpty = true;
                    map.addEntity(coordinates, clazz.getDeclaredConstructor(Coordinates.class).newInstance(coordinates));
                }
            } while(!isCellEmpty);
        }
    }
}
