package hw07.ru.otus.java.basic.moveble;

import hw07.ru.otus.java.basic.terrain.Terrain;

public interface Moveble {
    boolean move(Terrain terrain, int distance);
}
