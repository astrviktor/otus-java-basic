package hw19.ru.otus.java.basic.fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public List<T> getFruits() {
        return fruits;
    }

    public Box() {
        fruits = new ArrayList<>();
    }

    public void add(T... fruit) {
        fruits.addAll(Arrays.asList(fruit));
    }

    public int weight() {
        int weight = 0;
        for (T fruit : fruits) {
            weight+=fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box other) {
        return this.weight() == other.weight();
    }

    public void clear() {
        fruits = new ArrayList<>();
    }

    public void pour(Box<? extends T> other) {
        List fruits = other.getFruits();
        other.clear();

        for (Object fruit : fruits) {
            this.fruits.add((T) fruit);
        }
    }
}
