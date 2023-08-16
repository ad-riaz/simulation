package model.entity;

import model.Map;
import service.PropertiesLoader;

import javax.xml.stream.events.EndElement;
import java.util.Properties;

public abstract class Entity {
    protected Coordinates coordinates;

    public final String representation;

    protected static Properties conf = PropertiesLoader.loadProperties();


    public Entity(Coordinates coordinates, String representation) {
        this.coordinates = coordinates;
        this.representation = representation;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCoordinates(int latitude, int longitude) {
        this.coordinates = new Coordinates(latitude, longitude);
    }

    public void setLatitude(int latitude) {
        this.coordinates.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.coordinates.longitude = longitude;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getLatitude() {
        return coordinates.latitude;
    }

    public int getLongitude() {
        return coordinates.longitude;
    }

    public String getRepresentation() {
        return representation;
    }

    @Override
    public String toString() {
        return representation + "{" +
                coordinates +
                '}';
    }
}
