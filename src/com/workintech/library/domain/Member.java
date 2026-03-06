package com.workintech.library.domain;
import java.util.*;



abstract public class Member extends Person {

    private final Set<LibraryItem> borrowedItems = new HashSet<>();

    public Member(String name) {
        super(name);
    }

    public Set<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void addBorrowedItem(LibraryItem item){
        borrowedItems.add(item);
    }

    public void removeBorrowedItem(LibraryItem item){
        borrowedItems.remove(item);
    }
    /*
    public boolean borrowLimitExceeded(){
        return borrowedItems.size() >= getBorrowedLimit();
    }
    */
    public abstract int getBorrowedLimit();

}
