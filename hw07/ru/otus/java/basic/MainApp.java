package hw07.ru.otus.java.basic;

import hw07.ru.otus.java.basic.terrain.Terrain;
import hw07.ru.otus.java.basic.transport.Bicycle;
import hw07.ru.otus.java.basic.transport.Car;
import hw07.ru.otus.java.basic.transport.Horse;
import hw07.ru.otus.java.basic.transport.Truck;

public class MainApp {
    public static void main(String[] args) {
        Human human = new Human("Tom");

        Bicycle bicycle = new Bicycle();
        Horse horse = new Horse(100);
        Car car = new Car(60);
        Truck truck = new Truck(105);

        human.move(Terrain.FOREST, 10);

        human.getInTransport(bicycle);
        human.move(Terrain.FOREST, 10);
        human.getOutTransport();

        human.getInTransport(horse);
        human.move(Terrain.SWAMP, 10);
        human.getOutTransport();

        human.getInTransport(car);
        human.move(Terrain.PLAIN, 10);
        human.getOutTransport();

        human.getInTransport(truck);
        human.move(Terrain.FOREST, 10);
        human.getOutTransport();
    }
}
