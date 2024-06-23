package hw12.ru.otus.java.basic;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.io.File.separator;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        printFileListByMask(System.getProperty("user.dir"), "*.txt");

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scan.next();

        String selectedFile = System.getProperty("user.dir") + separator + fileName;

        System.out.println("\nСодержимое файла:");
        printFileData(selectedFile);

        System.out.print("Введите текст для добавления: ");
        String text = scan.next();

        addStringToFile(selectedFile, text);

        System.out.println("\nТекст добавлен в файл, новое содержимое: ");
        printFileData(selectedFile);

        scan.close();
    }

    public static void addStringToFile(String path, String data) {
        try
        {
            FileWriter file = new FileWriter(path,true);
            file.write(data + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFileData(String path) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(path))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char)n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFileList(String directoryPath, boolean filesOnly) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] filesList = directory.listFiles();
            if (filesList != null) {
                System.out.println("Содержимое директории " + directoryPath + ":");
                for (File file : filesList) {
                    if (filesOnly) {
                        if (!file.isDirectory()) {
                            System.out.println("[Файл] " + file.getName());
                        }
                    } else {
                        if (file.isDirectory()) {
                            System.out.println("[Директория] " + file.getName());
                        } else {
                            System.out.println("[Файл] " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("Произошла ошибка при чтении содержимого директории.");
            }
        } else {
            System.out.println(directoryPath + " не является директорией.");
        }
    }

    public static void printFileListByMask(String directoryPath, String mask) {
        File directory = new File(directoryPath);
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + mask);
        if (directory.isDirectory()) {
            File[] filesList = directory.listFiles();
            if (filesList != null) {
                System.out.println("Содержимое директории " + directoryPath + " с маской " + mask + ":");
                for (File file : filesList) {
                    if (pathMatcher.matches(Paths.get(file.getName()))) {
                        if (file.isDirectory()) {
                            System.out.println("[Директория] " + file.getName());
                        } else {
                            System.out.println("[Файл] " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("Произошла ошибка при чтении содержимого директории.");
            }
        } else {
            System.out.println(directoryPath + " не является директорией.");
        }
    }
}
