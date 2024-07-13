package hw21.ru.otus.java.basic;

public class WaitNotifySimpleApp {
    private class Counter {
        private char value;

        public Counter(char value) {
            this.value = value;
        }

        public void next() {
            switch (value) {
                case 'A':
                    value = 'B';
                    break;
                case 'B':
                    value = 'C';
                    break;
                case 'C':
                    value = 'A';
                    break;
            }
        }
    }

    private final Object mon = new Object();
    private Counter counter = new Counter('A');
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
                e.printStackTrace();
            }
        }
    }
}
