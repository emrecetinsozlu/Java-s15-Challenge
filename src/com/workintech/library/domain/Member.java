package com.workintech.library.domain;
import java.util.ArrayList;
import java.util.List;



abstract public class Member extends Person {

    private List<ArrayList> borrowedItems = new ArrayList<>();



    public Member(int id,String name) {
        super(id,name);
    }

    public List<ArrayList> getBorrowedItems() {
        return borrowedItems;
    }

    public abstract int getMaxLimit();
}
