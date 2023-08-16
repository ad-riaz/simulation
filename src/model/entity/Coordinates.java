package model.entity;

import model.Map;
import model.entity.creature.CoordinatesShift;

public class Coordinates {
    public int latitude;
    public int longitude;

    public Coordinates(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(latitude + shift.shiftLatitude, longitude + shift.shiftLongitude);
    }

    public boolean canShift(CoordinatesShift shift) {
        int lt = latitude + shift.shiftLatitude;
        int lg = longitude + shift.shiftLongitude;

        if (lt < 1 || lt > Map.height) return false;
        if (lg < 1 || lg > Map.width) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (latitude != that.latitude) return false;
        return longitude == that.longitude;
    }

    @Override
    public int hashCode() {
        int result = latitude;
        result = 31 * result + longitude;
        return result;
    }
}
