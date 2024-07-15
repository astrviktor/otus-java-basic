package hw20.ru.otus.java.basic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        String fileName, substring;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите имя файла: ");
            fileName = scanner.nextLine();

            System.out.print("Введите искомую последовательность символов: ");
            substring = scanner.nextLine();
        }

        int count = countSubstringOccurrences(fileName, substring);

        System.out.println("Количество вхождений: " + count);
    }

    private static int countSubstringOccurrences(String fileName, String substring) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int index = 0;
                while ((index = line.indexOf(substring, index)) != -1) {
                    count++;
                    index += substring.length();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }
}
