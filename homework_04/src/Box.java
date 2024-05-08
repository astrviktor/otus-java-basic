import java.util.Objects;

public class Box {
    private int length;
    private int width;
    private int height;
    private String color;
    private boolean isOpen;
    private String item;

    public Box(int length, int width, int height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;

        this.isOpen = false;
        this.item = "-";
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("Коробка перекрашена, новый цвет: " + color);
    }

    public void setOpen(boolean open) {
        isOpen = open;
        if (isOpen) {
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка закрыта");
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void putItem(String newItem) {
        if (!isOpen) {
            System.out.println("Коробка закрыта, нужно сначала открыть");
            return;
        }
        if (!Objects.equals(item, "-")) {
            System.out.println("В коробке лежит предмет " + item + ", нужно сначала выкинуть");
            return;
        }
        System.out.println("Предмет " + newItem + " положили в коробку");
        item = newItem;
    }

    public void dropItem() {
        if (!isOpen) {
            System.out.println("Коробка закрыта, нужно сначала открыть");
            return;
        }
        if (Objects.equals(item, "-")) {
            System.out.println("В коробке нет предмета, нужно сначала положить");
            return;
        }
        System.out.println("Предмет " + item + " выкинут");
        item = "-";
    }

    public void printInfo() {
        System.out.print("Коробка");
        System.out.print(" размеры: (д-ш-в) " + length + "-" + width + "-" + height);
        System.out.print(" цвет: " + color);
        System.out.print(" открыта: " + isOpen);
        System.out.println(" предмет: " + item);
    }
}
