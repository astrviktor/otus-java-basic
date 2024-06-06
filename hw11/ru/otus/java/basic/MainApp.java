package hw11.ru.otus.java.basic;

import hw11.ru.otus.java.basic.employee.Employee;
import hw11.ru.otus.java.basic.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee("Сотрудник 1", 39),
            new Employee("Сотрудник 2", 19),
            new Employee("Сотрудник 3", 49),
            new Employee("Сотрудник 4", 53),
            new Employee("Сотрудник 5", 42),
            new Employee("Сотрудник 6", 51),
            new Employee("Сотрудник 7", 48),
            new Employee("Сотрудник 8", 21),
            new Employee("Сотрудник 9", 33)
        ));

        Tree<Employee> tree = new Tree<>();

        for (Employee value : employeeList) {
            tree.insert(value);
        }

        Employee employee = new Employee("Сотрудник 5", 42);
        System.out.println("Поиск сотрудника: " + employee);
        System.out.println("Результат: " + tree.find(employee));

        employee = new Employee("Сотрудник 10", 77);
        System.out.println("Поиск сотрудника: " + employee);
        System.out.println("Результат: " + tree.find(employee));

        List<Employee> sortedEmployeeList = tree.getSortedList();
        System.out.println("Отсортированный список сотрудников:");
        for (Employee value : sortedEmployeeList) {
            System.out.println(value);
        }
    }
}
