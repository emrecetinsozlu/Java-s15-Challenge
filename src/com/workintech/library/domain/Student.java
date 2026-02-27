package com.workintech.library.domain;

public class Student extends Member {

    public Student(int id, String name) {
        super(id, name);
    }

    @Override
    public int getMaxLimit() {
        return 5;
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
