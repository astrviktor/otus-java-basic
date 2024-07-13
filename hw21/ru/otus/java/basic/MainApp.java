package hw21.ru.otus.java.basic;

public class MainApp {
    public static void main(String[] args) {
        WaitNotifySimpleApp waitNotifyApp = new WaitNotifySimpleApp();
        new Thread(() -> {
            waitNotifyApp.printSymbol('A');
        }).start();
        new Thread(() -> {
            waitNotifyApp.printSymbol('B');
        }).start();
        new Thread(() -> {
            waitNotifyApp.printSymbol('C');
        }).start();
    }
}
