package hw07.ru.otus.java.basic.transport;

import hw07.ru.otus.java.basic.moveble.Moveble;
import hw07.ru.otus.java.basic.terrain.Terrain;

public class Truck implements Moveble {
    private int gasolineAmount;
    private final int consumption;

    public Truck(int gasolineAmount) {
        this.gasolineAmount = gasolineAmount;
        consumption = 10;
    }

    @Override
    public boolean move(Terrain terrain, int distance) {
        int gasolineUse = consumption * distance;

        if (gasolineAmount >= gasolineUse) {
            gasolineAmount -= gasolineUse;
            System.out.println("Грузовик проехал на расстояние: " + distance);
            System.out.println("У грузовика осталось бензина: " + gasolineAmount);
            return true;
        }

        System.out.println("Грузовику не хватило бензина");
        System.out.println("У грузовика осталось бензина: " + gasolineAmount);
        return false;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "gasolineAmount=" + gasolineAmount +
                ", consumption=" + consumption +
                '}';
    }
}
