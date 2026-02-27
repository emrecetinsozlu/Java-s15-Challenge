package com.workintech.library.domain;

public class Faculty extends Member {


    public Faculty(int id, String name) {
        super(id, name);
    }

    @Override
    public int getMaxLimit() {
        return 10;
    }


    @Override
    public String getRole() {
        return "Faculty";
    }
}
