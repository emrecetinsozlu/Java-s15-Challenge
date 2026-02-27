package com.workintech.library.domain;

public class Author extends Person{
    public Author(int id, String name){
        super(id,name);
    }

    @Override
    public String getRole() {
        return "Author";
    }

}
