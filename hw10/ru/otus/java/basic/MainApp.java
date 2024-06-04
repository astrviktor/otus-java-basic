package hw10.ru.otus.java.basic;

import hw10.ru.otus.java.basic.phonebook.PhoneBook;

public class MainApp {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иван", "+79000000001");
        phoneBook.add("Иван", "+79000000002");
        phoneBook.add("Сергей", "+79000000003");

        String findName = "Иван";
        System.out.println("Список номеров с именем '" + findName + "': " + phoneBook.find(findName));

        findName = "Федор";
        System.out.println("Список номеров с именем '" + findName + "': " + phoneBook.find(findName));

        String checkPhone = "+79000000002";
        System.out.println("Проверка номера '" + checkPhone + "': " + phoneBook.containsPhoneNumber(checkPhone));

        checkPhone = "+79000000004";
        System.out.println("Проверка номера '" + checkPhone + "': " + phoneBook.containsPhoneNumber(checkPhone));
    }
}
