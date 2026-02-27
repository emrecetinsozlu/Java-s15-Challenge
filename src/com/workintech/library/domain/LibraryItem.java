package com.workintech.library.domain;

public abstract class LibraryItem {
    private String title;
    private int id;
    private double price;
    private ItemStatus status;

    public LibraryItem(String title, int id, double price) {
        this.title = title;
        this.id = id;
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
    public boolean isAvailable() {
        return status == ItemStatus.AVAILABLE;
    }

    public void markBorrowed() {
        this.status = ItemStatus.BORROWED;
    }

    public void markReturned() {
        this.status = ItemStatus.AVAILABLE;
    }

    // Polymorphism için: her item kendini farklı tanıtabilir
    public abstract String getItemType();
}



/*
Neden abstract?
“LibraryItem” tek başına gerçek bir nesne değil; Book, Magazine gibi türleri olacak.
Ortak alanlar + ortak davranışlar burada; tür-specifik kısmı alt sınıflar doldurur.

*/

