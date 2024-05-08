public class Homework03 {
    public static void main(String[] args) {
        int[][] array2d = {{-1,2,-3}, {1}, {-1}};
        int result = sumOfPositiveElements(array2d);
        System.out.println("result = " + result);
        System.out.println();

        printSquare(5);
        System.out.println();

        int[][] array = {{1,2,3}, {4,5,6}, {7,8,9}};
        arrayZeroDiagonal(array);
        printArray(array);
        System.out.println();

        int[][] arr1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int max1 = findMax(arr1);
        System.out.println("max = " + max1);

        int[][] arr2 = {{}, {}, {1}};
        int max2 = findMax(arr2);
        System.out.println("max = " + max2);

        int sum1 = sumArraySecondString(arr1);
        System.out.println("sum = " + sum1);

        int sum2 = sumArraySecondString(arr2);
        System.out.println("sum = " + sum2);
    }

    public static int sumOfPositiveElements(int[][] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    result += array[i][j];
                }
            }
        }

        return result;
    }

    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print('*' + " ");
            }
            System.out.println();
        }
    }

    public static void arrayZeroDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 0;
            array[i][(array.length - 1) - i] = 0;
        }
    }

    public static int findMax(int[][] array) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }

        return max;
    }

    public static int sumArraySecondString(int[][] array) {
        if (array.length < 2 ) {
            return -1;
        }

        if (array[1].length == 0) {
            return -1;
        }

        int sum = 0;
        for (int j = 0; j < array[1].length; j++) {
            sum += array[1][j];
        }

        return sum;
    }


    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}