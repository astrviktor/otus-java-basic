package hw14.ru.otus.java.basic;

public class MainApp {
    private static double [] array;

    public static void main(String[] args) throws InterruptedException {
        array = new double[100_000_000];

        long time = System.currentTimeMillis();
        fillArrayIn1Thread();
        System.out.println("one thread used time, ms: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        fillArrayIn4Thread();
        System.out.println("four thread used time, ms: " + (System.currentTimeMillis() - time));
    }

    private static void fillArrayIn1Thread() {
        for (int i = 0; i < array.length; i++) {
            array[i] = getArrayElementValue(i);
        }
    }

    private static void fillArrayIn4Thread() throws InterruptedException {
        Thread t1 = makeAndStartThread(0, 25_000_000);
        Thread t2 = makeAndStartThread(25_000_000, 25_000_000);
        Thread t3 = makeAndStartThread(50_000_000, 25_000_000);
        Thread t4 = makeAndStartThread(75_000_000, 25_000_000);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

    private static Thread makeAndStartThread(int indexStart, int lenght) {
        Thread thread = new Thread(() -> {
            for (int i = indexStart; i < indexStart + lenght; i++) {
                array[i] = getArrayElementValue(i);
            }
        });

        return thread;
    }

    private static double getArrayElementValue(int i) {
        return 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
    }
}
