package hw06.ru.otus.java.basic;

public class Cat {
    private String name;
    private int foodConsumption;
    private boolean isHungry;

    public Cat(String name, int foodConsumption) {
        this.name = name;
        this.foodConsumption = foodConsumption;
        isHungry = true;
    }

    public void eat(Plate plate) {
        if (isHungry) {
            if (plate.eatFood(foodConsumption)) {
                isHungry = false;
                System.out.println(name + " поел " + foodConsumption + " едениц еды");
            } else {
                System.out.println(name + " не поел, не хватило еды");
            }
        } else {
            System.out.println(name + " не голодный");
        }
    }
}
