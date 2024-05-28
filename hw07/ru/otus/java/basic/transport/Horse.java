package hw07.ru.otus.java.basic.transport;

import hw07.ru.otus.java.basic.moveble.Moveble;
import hw07.ru.otus.java.basic.terrain.Terrain;

public class Horse implements Moveble {
    private int power;
    private final int consumption;

    public Horse(int power) {
        this.power = power;
        consumption = 1;
    }

    @Override
    public boolean move(Terrain terrain, int distance) {
        int powerUse = consumption * distance;

        if (power >= powerUse) {
            if (terrain != Terrain.SWAMP) {
                power -= powerUse;
                System.out.println("Лошадь проехала на расстояние: " + distance);
                System.out.println("У лошади осталось сил: " + power);
                return true;
            } else {
                System.out.println("Лошадь не поехала по местности: " + terrain);
                return false;
            }
        }

        System.out.println("Лошади не хватило сил");
        System.out.println("У лошади осталось сил: " + power);
        return false;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "power=" + power +
                ", consumption=" + consumption +
                '}';
    }
}
