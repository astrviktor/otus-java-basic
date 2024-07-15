package hw21.ru.otus.java.basic;

public class WaitNotifySimpleApp {
    private static class Counter {
        private char value;

        public Counter(char value) {
            this.value = value;
        }

        public void next() {
            value = (char) ((value - 'A' + 1) % 3 + 'A');
        }
    }

    private final Object mon = new Object();
    private final Counter counter = new Counter('A');
    private static final int WORK_COUNT = 5;

    public void printSymbol(char symbol) {
        synchronized (mon) {
            try {
                for (int i = 0; i < WORK_COUNT; i++) {
                    while (counter.value != symbol) {
                        mon.wait();
                    }
                    System.out.print(symbol);
                    counter.next();
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
