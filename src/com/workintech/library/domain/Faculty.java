package com.workintech.library.domain;

public class Faculty extends Member {


    public Faculty(String name) {
        super(name);
    }

    @Override
    public int getBorrowedLimit() {
        return 10;
    }

    @Override
    public String getRole() {
        return "Faculty";
    }
}
