public class User {
    private String lastName;
    private String firstName;
    private String surName;
    private int birthYear;
    private String email;

    public User(String lastName, String firstName, String surName, int birthYear, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int calculateAge() {
        int currentYear = 2024;
        return currentYear - birthYear;
    }

    public void printInfo() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + surName);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("e-mail: " + email);
    }
}
