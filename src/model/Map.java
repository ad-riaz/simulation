package model;

import model.entity.Coordinates;
import model.entity.Entity;
import service.PropertiesLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class Map {

    static Properties conf = PropertiesLoader.loadProperties();
    public static final int width = Integer.parseInt(conf.getProperty("map.width"));
    public static final int height = Integer.parseInt(conf.getProperty("map.height"));
    private HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void addEntity(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public List<Entity> getEntities() {
        List<Entity> list = new ArrayList<>(entities.size());
        for (HashMap.Entry<Coordinates, Entity> entry : entities.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }
}
