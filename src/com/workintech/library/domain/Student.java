package com.workintech.library.domain;

public class Student extends Member {

    public Student(String name) {
        super(name);
    }

    @Override
    public int getBorrowedLimit() {
        return 5;
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
