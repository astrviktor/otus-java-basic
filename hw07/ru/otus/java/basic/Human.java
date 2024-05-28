package hw07.ru.otus.java.basic;

import hw07.ru.otus.java.basic.moveble.Moveble;
import hw07.ru.otus.java.basic.terrain.Terrain;

public class Human  implements Moveble {
    private String name;
    private Moveble currentTransport;
    private boolean isUseTransport;

    public Human(String name) {
        this.name = name;
        isUseTransport = false;
    }

    public void getInTransport(Moveble transport) {
        if (!isUseTransport) {
            currentTransport = transport;
            isUseTransport = true;
            System.out.println(name + " сел в транспорт " + currentTransport);
        }
    }

    public void getOutTransport() {
        if (isUseTransport) {
            isUseTransport = false;
            System.out.println(name + " покинул транспорт " + currentTransport);
        }
    }

    @Override
    public boolean move(Terrain terrain, int distance) {
        if (isUseTransport) {
            System.out.println(name + " использует транспорт " + currentTransport + " для перемещения");
            return currentTransport.move(terrain, distance);
        }

        System.out.println(name + " идет пешком по " + terrain);
        return true;
    }
}
