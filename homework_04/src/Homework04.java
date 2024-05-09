public class Homework04 {
    public static void main(String[] args) {
        User[] users = {
                new User("Иванов", "Иван", "Иванович", 1985, "ivanov85@example.com"),
                new User("Петров", "Петр", "Петрович", 1990, "petrov90@example.com"),
                new User("Сидоров", "Александр", "Владимирович", 1982, "sidorov82@example.com"),
                new User("Козлова", "Екатерина", "Дмитриевна", 1978, "kozlova78@example.com"),
                new User("Смирнова", "Ольга", "Васильевна", 1987, "smirnova87@example.com"),
                new User("Никитина", "Татьяна", "Сергеевна", 1995, "nikitina95@example.com"),
                new User("Кузнецов", "Денис", "Алексеевич", 1980, "kuznetsov80@example.com"),
                new User("Морозов", "Дмитрий", "Павлович", 1992, "morozov92@example.com"),
                new User("Павлова", "Анна", "Игоревна", 1989, "pavlova89@example.com"),
                new User("Васильев", "Андрей", "Степанович", 1984, "vasiliev84@example.com"),
        };

        for (int i = 0; i < users.length; i++) {
            if (users[i].calculateAge() > 40) {
                users[i].printInfo();
                System.out.println();
            }
        }

        System.out.println("-------------------------");

        Box box = new Box(10, 20, 30, "красный");
        box.printInfo();

        box.setColor("зеленый");
        box.printInfo();

        box.putItem("книга");
        box.open();
        box.putItem("книга");

        box.printInfo();
        box.dropItem();
        box.close();
    }
}