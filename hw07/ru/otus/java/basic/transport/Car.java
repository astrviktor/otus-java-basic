package hw07.ru.otus.java.basic.transport;

import hw07.ru.otus.java.basic.moveble.Moveble;
import hw07.ru.otus.java.basic.terrain.Terrain;

public class Car implements Moveble {
    private int gasolineAmount;
    private final int consumption;

    public Car(int gasolineAmount) {
        this.gasolineAmount = gasolineAmount;
        consumption = 5;
    }

    @Override
    public boolean move(Terrain terrain, int distance) {
        int gasolineUse = consumption * distance;

        if (gasolineAmount >= gasolineUse) {
            if (terrain != Terrain.FOREST && terrain != Terrain.SWAMP) {
                gasolineAmount -= gasolineUse;
                System.out.println("Машина проехала на расстояние: " + distance);
                System.out.println("У машины осталось бензина: " + gasolineAmount);
                return true;
            } else {
                System.out.println("Машина не поехала по местности: " + terrain);
                return false;
            }
        }

        System.out.println("Машине не хватило бензина");
        System.out.println("У машины осталось бензина: " + gasolineAmount);
        return false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "gasolineAmount=" + gasolineAmount +
                ", consumption=" + consumption +
                '}';
    }
}
