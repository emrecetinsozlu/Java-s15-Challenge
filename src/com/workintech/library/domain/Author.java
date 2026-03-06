package com.workintech.library.domain;

public class Author extends Person{

    public Author(String name){
        super(name);
    }

    @Override
    public String getRole() {
        return "Author";
    }

}
