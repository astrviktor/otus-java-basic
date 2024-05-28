package hw07.ru.otus.java.basic.transport;

import hw07.ru.otus.java.basic.moveble.Moveble;
import hw07.ru.otus.java.basic.terrain.Terrain;

public class Bicycle implements Moveble {
    public Bicycle() {}

    @Override
    public boolean move(Terrain terrain, int distance) {
        if (terrain != Terrain.SWAMP) {
            System.out.println("Велосипед проехал на расстояние: " + distance);
            return true;
        } else {
            System.out.println("Велосипед не поехал по местности: " + terrain);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Bicycle{}";
    }
}
