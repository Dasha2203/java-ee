package by.tms;

import java.util.Comparator;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d", name, age);
    }

    public static Comparator<User> getComparator(String sortBy) {
        switch (sortBy) {
            case "name":
                return Comparator.comparing(User::getName);
            case "age":
                return Comparator.comparingInt(User::getAge);
            case "id":
            default:
                return null;
        }
    }
}
