package com.workintech.library.domain;




abstract public class Person {
    private static int idCounter = 1;
    private final int id;
    private final String name;

    // Görev constructer oluşturmak
    public Person(String name) {
        this.id = idCounter++;
        this.name = name;
    }
    // Encapsulation
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public abstract String getRole();

    @Override
    public String toString() {
        return "İsim: " + name
                + ", ID: " + id;
    }
}
