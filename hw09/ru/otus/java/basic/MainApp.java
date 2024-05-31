package hw09.ru.otus.java.basic;

import hw09.ru.otus.java.basic.employee.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Integer> list = createArrayListBetweenMinMax(1,10);
        System.out.println(list);

        int sum = sumArrayListElemMoreThan5(list);
        System.out.println("Сумма элементов которые больше 5: " + sum);

        addNumberToArrayListElems(list, 1);
        System.out.println(list);

        setNumberToArrayListElems(list, 3);
        System.out.println(list);

        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee("Сотрудник 1", 25),
                new Employee("Сотрудник 2", 20),
                new Employee("Сотрудник 3", 18),
                new Employee("Сотрудник 4", 30),
                new Employee("Сотрудник 5", 45)
        ));

        ArrayList<String> namesList = getEmployeeNameList(employeeList);
        System.out.println("Имена сотрудников: " + namesList);

        int minAge = 25;
        List<Employee> checkMinAgeList = checkEmployeeMinAge(employeeList, minAge);
        System.out.println("Список сотрудников с возрастом >= " + minAge + ": " + checkMinAgeList);

        int averageAge = 20;
        boolean check = checkEmployeeAverageAge(employeeList, averageAge);
        System.out.println("Средний возраст > " + averageAge + ": "+ check);

        Employee youngest = findYoungestEmployee(employeeList);
        System.out.println("Самый молодой: " + youngest);
    }

    public static ArrayList<String> getEmployeeNameList(List<Employee> employees) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee e : employees) {
           names.add(e.getName());
        }
        return names;
    }

    public static List<Employee> checkEmployeeMinAge(List<Employee> employees, int minAge) {
        List<Employee> result = new LinkedList<>();
        for (Employee e : employees) {
            if (e.getAge() >= minAge) {
                result.add(e);
            }
        }
        return result;
    }

    public static boolean checkEmployeeAverageAge(List<Employee> employees, int averageAge) {
        int sumAge = 0;
        for (Employee e : employees) {
            sumAge += e.getAge();
        }
        int resAverageAge = sumAge / employees.size();
        return resAverageAge > averageAge;
    }

    public static Employee findYoungestEmployee(List<Employee> employees) {
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

    public static int sumArrayListElemMoreThan5(ArrayList<Integer> array) {
        int sum = 0;
        for (Integer elem : array) {
            if (elem > 5) {
                sum += elem;
            }
        }
        return sum;
    }

    public static void setNumberToArrayListElems(ArrayList<Integer> array, int number) {
        array.replaceAll(integer -> number);
    }

    public static void addNumberToArrayListElems(ArrayList<Integer> array, int number) {
        for (int i = 0; i < array.size(); i++) {
            array.set(i, array.get(i) + number);
        }
    }

}
