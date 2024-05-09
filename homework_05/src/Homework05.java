import animals.Animal;
import animals.Dog;
import animals.Cat;
import animals.Horse;

public class Homework05 {
    public static void main(String[] args) {
        float time;

        Animal dog = new Dog("Собака", 2, 1, 100);
        dog.info();
        time = dog.run(10);
        dog.info();
        time = dog.swim(10);
        dog.info();
        time = dog.run(100);
        dog.info();
        time = dog.swim(100);
        dog.info();

        System.out.println("-----");

        Animal cat = new Cat("Кот", 1, 0, 20);
        cat.info();
        time = cat.run(10);
        cat.info();
        time = cat.swim(10);
        cat.info();
        time = cat.run(100);
        cat.info();
        time = cat.swim(100);
        cat.info();

        System.out.println("-----");

        Animal horse = new Horse("Лошадь", 10, 1, 200);
        horse.info();
        time = horse.run(10);
        horse.info();
        time = horse.swim(10);
        horse.info();
        time = horse.run(100);
        horse.info();
        time = horse.swim(100);
        horse.info();
    }
}
