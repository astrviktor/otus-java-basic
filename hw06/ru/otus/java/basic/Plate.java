package hw06.ru.otus.java.basic;

public class Plate {
    private int maxFoodValue;
    private int currentFoodValue;

    public Plate(int maxFoodValue) {
        this.maxFoodValue = maxFoodValue;
        this.currentFoodValue = maxFoodValue;
        System.out.println("Создана тарелка с количеством еды " + currentFoodValue);
    }

    public void addFood(int value) {
        currentFoodValue += value;
        if (currentFoodValue > maxFoodValue) {
            currentFoodValue = maxFoodValue;
        }
        System.out.println("В тарелку добавлена еда, текущее значение " + currentFoodValue);
    }

    public boolean eatFood(int value) {
        if (currentFoodValue < value) {
            System.out.println("Попытка расхода еды " + value + ", еды недостаточно");
            return false;
        }
        currentFoodValue -= value;
        System.out.println("Расход еды " + value);
        return true;
    }
}
