package hw20.ru.otus.java.basic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите искомую последовательность символов: ");
        String substring = scanner.nextLine();

        scanner.close();

        int count = countSubstringOccurrences(fileName, substring);

        System.out.println("Количество вхождений: " + count);
    }

    private static int countSubstringOccurrences(String fileName, String substring) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
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
