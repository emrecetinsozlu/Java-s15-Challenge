package com.workintech.library.domain;

import java.util.Objects;

public abstract class LibraryItem {
    private String title;
    private static int idCounter = 1;
    private int id;
    private double price;
    private ItemStatus status;

    public LibraryItem(String title, double price) {
        this.title = title;
        this.id = idCounter++;
        this.price = price;
        this.status = ItemStatus.AVAILABLE;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void markBorrowed() {
        this.status = ItemStatus.BORROWED;
    }

    public void markReturned() {
        this.status = ItemStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return this.status == ItemStatus.AVAILABLE;
    }

    // Polymorphism için: her item kendini farklı tanıtabilir
    public abstract String getItemType();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LibraryItem that = (LibraryItem) o;
        return Objects.equals(this.id,that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
       return "Title: " + title;
    }
}



/*
Neden abstract?
“LibraryItem” tek başına gerçek bir nesne değil; Book, Magazine gibi türleri olacak.
Ortak alanlar + ortak davranışlar burada; tür-specifik kısmı alt sınıflar doldurur.

*/

