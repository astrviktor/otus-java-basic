package hw22.ru.otus.java.basic;

import java.util.Arrays;

public class ArrayFunctions {
    public int[] getArrayAfterLastOne(int[] array) {
        int lastOnePositionOfOne = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                lastOnePositionOfOne = i;
            }
        }

        if (lastOnePositionOfOne >= 0) {
            int[] result = Arrays.copyOfRange(array, lastOnePositionOfOne+1, array.length);
            return result;
        }

        throw new RuntimeException();
    }

    public boolean checkArrayContainsOneAndTwoOnly(int[] array) {
        boolean containsOne = false;
        boolean containsTwo = false;
        boolean containsOther = false;
        for (int elem : array) {
            switch (elem) {
                case 1:
                    containsOne = true;
                    break;
                case 2:
                    containsTwo = true;
                    break;
                default:
                    containsOther = true;
                    break;
            }
        }

        return (containsOne && containsTwo) && !containsOther;
    }
}
