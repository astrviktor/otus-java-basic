import java.util.Arrays;

public class Homework02 {
    public static void main(String[] args) {
        printRepeat(2,"Hello world!");

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        sumElementsGreaterThan5(array);

        fillArray(10, array);
        System.out.println(Arrays.toString(array));

        increaseArrayElementsByValue(12, array);
        System.out.println(Arrays.toString(array));

        compareHalfArraySum(array);
        compareHalfArraySum(new int[] {-1, 0, 3, 4, 5, 9, 12});
        compareHalfArraySum(new int[] {10, 20, 30, 4, 5, 9, 12});

        // hard (*)
        int[] array1 = { 1, 2, 3 };
        int[] array2 = { 2, 2 };
        int[] array3 = { 1, 1, 1, 1, 1 };
        sumElementsOfArrays(array1, array2, array3);

        checkArrayDot(new int[] { 1, 1, 1, 1, 1, 5 });
        checkArrayDot(new int[] { 5, 3, 4, -2 });
        checkArrayDot(new int[] { 7, 2, 2, 2 });
        checkArrayDot(new int[] { 9, 4 });

        array = new int[]{1, 2, 3, 4, 5, 6};
        checkArrayElementsDecreaseOrIncrease(true, array);
        checkArrayElementsDecreaseOrIncrease(false, array);
        array = new int[]{6, 5, 4, 3, 2, 1};
        checkArrayElementsDecreaseOrIncrease(true, array);
        checkArrayElementsDecreaseOrIncrease(false, array);

        array = new int[]{1, 2, 3, 4, 5, 6};
        turnArrayOver(array);
        System.out.println(Arrays.toString(array));
    }

    public static void printRepeat(int n, String str) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    public static void sumElementsGreaterThan5(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5) {
                sum += array[i];
            }
        }
        System.out.println("Сумма элементов массива, которые > 5, равна: " + sum);
    }

    public static void fillArray(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    public static void increaseArrayElementsByValue(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += value;
        }
    }

    public static void compareHalfArraySum(int[] array) {
        int leftHalfSum = 0;
        int rightHalfSum = 0;
        for (int i = 0; i < array.length/2; i++) {
            leftHalfSum += array[i];
            rightHalfSum += array[array.length - 1 - i];
        }

        if (leftHalfSum == rightHalfSum) {
            System.out.println("Суммы равны: " + leftHalfSum + " = " + rightHalfSum);
            return;
        }

        if (leftHalfSum > rightHalfSum) {
            System.out.println("Сумма слева больше: " + leftHalfSum + " > " + rightHalfSum);
        } else {
            System.out.println("Сумма справа больше: " + leftHalfSum + " < " + rightHalfSum);
        }
    }

    // hard (*)
    public static void sumElementsOfArrays(int[]... arrays) {
        int biggestArrayLength = 0;
        for (int a = 0; a < arrays.length; a++) {
            System.out.println(Arrays.toString(arrays[a]));
            if (arrays[a].length > biggestArrayLength) {
                biggestArrayLength = arrays[a].length;
            }
        }

        int [] result = new int[biggestArrayLength];

        for (int a = 0; a < arrays.length; a++) {
            for (int i = 0; i < biggestArrayLength; i++) {
                if (i < arrays[a].length) {
                    result[i] += arrays[a][i];
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }

    public static void checkArrayDot(int[] array) {
        int rightPartSum = 0;
        for (int i = 0; i < array.length; i++) {
            rightPartSum += array[i];
        }

        int leftPartSum = 0;
        for (int i = 0; i < array.length; i++) {
            leftPartSum += array[i];
            rightPartSum -= array[i];
            if (leftPartSum == rightPartSum) {
                System.out.println("В массиве есть точка между "+ i + " и " + (i + 1) + " элементом");
                return;
            }
        }
        System.out.println("В массиве нет точек");
    }

    public static void checkArrayElementsDecreaseOrIncrease(boolean increase, int[] array) {
        boolean check = true;

        if (increase) {
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    check = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] < array[i+1]) {
                    check = false;
                    break;
                }
            }
        }

        if (increase) {
            System.out.print("Проверка - элементы идут в порядке возрастания: ");
        } else {
            System.out.print("Проверка - элементы идут в порядке убывания: ");
        }

        if (check) {
            System.out.println("да");
        } else {
            System.out.println("нет");
        }
    }

    public static void turnArrayOver(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int elem = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = elem;
        }
    }
}