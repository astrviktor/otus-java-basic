package hw07.ru.otus.java.basic.moveable;

import hw07.ru.otus.java.basic.terrain.Terrain;

public interface Moveable {
    boolean move(Terrain terrain, int distance);
}
