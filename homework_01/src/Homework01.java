import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        greetings();
        checkSign(1,2,3);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(10,20, true);

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число от 1 до 5: ");
        int num = scan.nextInt();
        scan.close();

        if (num == 1) {
            greetings();
            return;
        }

        if (num == 2) {
            int a = (int) (Math.random() * 200) - 100;
            int b = (int) (Math.random() * 200) - 100;
            int c = (int) (Math.random() * 200) - 100;
            System.out.println("a = " + a + ", b = " + b + ", c = " + c);
            checkSign(a,b,c);
            return;
        }

        if (num == 3) {
            selectColor();
            return;
        }

        if (num == 4) {
            compareNumbers();
            return;
        }

        if (num == 5) {
            int initValue = (int) (Math.random() * 100);
            int delta = (int) (Math.random() * 100);
            boolean increment = (Math.random() < 0.5);
            System.out.println("initValue = " + initValue + ", delta = " + delta + ", increment = " + increment);
            addOrSubtractAndPrint(initValue, delta, increment);
            return;
        }

        System.out.print("Неправильное число: " + num);
    }

    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        int result = a + b + c;
        if (result > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = (int) (Math.random() * 100);
        System.out.println("data = " + data);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20 ) {
            System.out.println("Желтый");
        } else if (data > 20) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        System.out.println("a = " + a + ", b = " + b);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            initValue += delta;
            System.out.println("initValue = " + initValue);
        } else {
            initValue -= delta;
            System.out.println("initValue = " + initValue);
        }
    }
}