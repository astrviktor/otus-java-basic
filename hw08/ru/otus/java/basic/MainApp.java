package hw08.ru.otus.java.basic;

import hw08.ru.otus.java.basic.exceptions.AppArrayDataException;
import hw08.ru.otus.java.basic.exceptions.AppArraySizeException;

public class MainApp {
    public static void main(String[] args) {
        String[][] array1 = {{"1"}};
        try {
            int result1 = sumNumericElements(array1);
            System.out.println("Результат: " + result1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String[][] array2 = {
            {"0", "0", "0", "0"},
            {"0", "0", "0", "0"},
            {"0", "0", "0", "0"},
            {"A", "0", "0", "0"},
        };

        try {
            int result2 = sumNumericElements(array2);
            System.out.println("Результат: " + result2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String[][] array3 = {
            {"1", "2", "3", "4"},
            {"2", "3", "4", "1"},
            {"3", "4", "1", "2"},
            {"4", "1", "2", "3"},
        };

        try {
            int result3 = sumNumericElements(array3);
            System.out.println("Результат: " + result3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumNumericElements(String[][] array) throws Exception {
        if (wrongArraySize(array)) {
            throw new AppArraySizeException("error: wrong array size");
        }

        int sum = 0;
        int number;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    number = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("error: array[" + i + "][" + j +"] = '" + array[i][j] + "' not int");
                }
                sum += number;
            }
        }

        return sum;
    }

    public static boolean wrongArraySize(String[][] array) {
        int size = 4;

        if (array.length != size) {
            return true;
        }

        for (String[] element : array) {
            if (element.length != size) {
                return true;
            }
        }

        return false;
    }
}
