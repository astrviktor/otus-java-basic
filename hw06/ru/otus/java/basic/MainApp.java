package hw06.ru.otus.java.basic;

public class MainApp {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 10),
                new Cat("Mursik", 20),
                new Cat("Pushok", 30),
        };

        Plate plate = new Plate(35);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

        plate.addFood(50);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }
    }
}
