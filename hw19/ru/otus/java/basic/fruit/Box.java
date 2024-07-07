package hw19.ru.otus.java.basic.fruit;

import java.util.ArrayList;
import java.util.Arrays;
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

    public double weight() {
        double weight = 0.0;
        for (T fruit : fruits) {
            weight+=fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> other) {
        return Math.abs(this.weight() - other.weight()) < 0.0001;
    }

    public void clear() {
        fruits = new ArrayList<>();
    }

    public void pour(Box<? extends T> other) {
        if (this == other) {
            System.out.println("Нельзя переложить коробку саму в себя");
            return;
        }

        List fruits = other.getFruits();
        if (fruits == null || fruits.isEmpty()) {
            System.out.println("Поступившая коробка пуста");
            return;
        }

        other.clear();
        for (Object fruit : fruits) {
            this.fruits.add((T) fruit);
        }
    }
}
