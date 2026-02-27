package com.workintech.library.domain;




abstract public class Person {
    private int id;
    private String name;

    // Görev constructer oluşturmak
    public Person(int id, String name) {
        this.id = id;
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
}
