package hw09.ru.otus.java.basic;

import hw09.ru.otus.java.basic.employee.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList
        // с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1)
        ArrayList<Integer> list = createArrayListBetweenMinMax(1,10);
        System.out.println(list);

        // Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы,
        // значение которых больше 5, и возвращающий сумму;
        int sum = sumArrayListElemMoreThan5(list);
        System.out.println("Сумма элементов которые больше 5: " + sum);

        // Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен
        // переписать каждую заполненную ячейку списка указанным числом;
        setNumberToArrayListElems(list, 3);
        System.out.println(list);

        // Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
        // увеличивающий каждый элемент списка на указанное число;
        addNumberToArrayListElems(list, 1);
        System.out.println(list);

        // Создайте класс Сотрудник с полями: имя, возраст;
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee("Сотрудник 1", 25),
                new Employee("Сотрудник 2", 20),
                new Employee("Сотрудник 3", 18),
                new Employee("Сотрудник 4", 30),
                new Employee("Сотрудник 5", 45)
        ));

        // Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
        List<String> namesList = getEmployeeNameList(employeeList);
        System.out.println("Имена сотрудников: " + namesList);

        // Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и возвращающий
        // список сотрудников, возраст которых больше либо равен указанному аргументу;
        int minAge = 25;
        List<Employee> checkMinAgeList = checkEmployeeMinAge(employeeList, minAge);
        System.out.println("Список сотрудников с возрастом >= " + minAge + ": " + checkMinAgeList);

        // Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст,
        // и проверяющий, что средний возраст сотрудников превышает указанный аргумент;
        int averageAge = 20;
        boolean check = checkEmployeeAverageAge(employeeList, averageAge);
        System.out.println("Средний возраст > " + averageAge + ": "+ check);

        // Реализуйте метод, принимающий в качестве аргумента список сотрудников,
        // и возвращающий ссылку на самого молодого сотрудника.
        Employee youngest = findYoungestEmployee(employeeList);
        System.out.println("Самый молодой: " + youngest);
    }

    public static List<String> getEmployeeNameList(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        List<String> names = new ArrayList<>();
        for (Employee e : employees) {
           names.add(e.getName());
        }
        return names;
    }

    public static List<Employee> checkEmployeeMinAge(List<Employee> employees, int minAge) {
        if (employees == null) {
            return null;
        }
        List<Employee> result = new LinkedList<>();
        for (Employee e : employees) {
            if (e.getAge() >= minAge) {
                result.add(e);
            }
        }
        return result;
    }

    public static boolean checkEmployeeAverageAge(List<Employee> employees, int averageAge) {
        if (employees == null) {
            return false;
        }
        if (employees.isEmpty()) {
            return false;
        }
        int sumAge = 0;
        for (Employee e : employees) {
            sumAge += e.getAge();
        }
        int resAverageAge = sumAge / employees.size();
        return resAverageAge > averageAge;
    }

    public static Employee findYoungestEmployee(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        if (employees.isEmpty()) {
            return null;
        }
        Employee result = employees.get(0);
        for (Employee e : employees) {
            if (e.getAge() < result.getAge()) {
                result = e;
            }
        }
        return result;
    }

    public static ArrayList<Integer> createArrayListBetweenMinMax(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int n = min; n <= max; n++) {
            list.add(n);
        }
        return list;
    }

    public static int sumArrayListElemMoreThan5(List<Integer> array) {
        if (array == null) {
            return -1;
        }
        int sum = 0;
        for (Integer elem : array) {
            if (elem > 5) {
                sum += elem;
            }
        }
        return sum;
    }

    public static void setNumberToArrayListElems(List<Integer> array, int number) {
        if (array == null) {
            return;
        }
        array.replaceAll(integer -> number);
    }

    public static void addNumberToArrayListElems(List<Integer> array, int number) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.size(); i++) {
            array.set(i, array.get(i) + number);
        }
    }

}
