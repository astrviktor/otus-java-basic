package hw19.ru.otus.java.basic;

import hw19.ru.otus.java.basic.fruit.Apple;
import hw19.ru.otus.java.basic.fruit.Orange;
import hw19.ru.otus.java.basic.fruit.Fruit;
import hw19.ru.otus.java.basic.fruit.Box;

public class MainApp {
    public static void main(String[] args) {
        Apple apple1 = new Apple(8);
        Apple apple2 = new Apple(14);
        Apple apple3 = new Apple(5);

        Orange orange1 = new Orange(10);
        Orange orange2 = new Orange(12);
        Orange orange3 = new Orange(7);

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> box = new Box<>();

        appleBox.add(apple1, apple2);
        orangeBox.add(orange1, orange2);
        box.add(apple3, orange3);

        System.out.println("Результат сравнения коробок с яблоками и апельсинами: " + appleBox.compare(orangeBox));
        System.out.println("Результат сравнения коробок с яблоками и фруктами: " + appleBox.compare(box));

        System.out.println("=====");

        System.out.println("Вес коробки с яблоками: " + appleBox.weight());
        System.out.println("Вес коробки с фруктами: " + box.weight());

        box.pour(appleBox);

        System.out.println("Вес коробки с яблоками: " + appleBox.weight());
        System.out.println("Вес коробки с фруктами: " + box.weight());

        // appleBox.pour(box); // ошибка по ограничению

        System.out.println("=====");

        Box<Apple> emptyAppleBox = new Box<>();
        Box<Fruit> emptyFruitBox = new Box<>();
        emptyAppleBox.pour(emptyAppleBox);
        emptyFruitBox.pour(emptyAppleBox);
    }
}
