package hw11.ru.otus.java.basic.employee;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{'" + name + "'," + age + '}';
    }

    @Override
    public int compareTo(Employee e) {
        if (this.equals(e)) {
            return 0;
        }

        if (age != e.getAge()) {
            if (age < e.getAge()) {
                return -1;
            } else {
                return 1;
            }
        }

        return name.compareTo(e.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
