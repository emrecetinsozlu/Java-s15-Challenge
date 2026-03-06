package com.workintech.library.domain;

//Author u Book içerisinde kullandık composition a bir örnek
public class Book extends LibraryItem {

    private Author author;
    private Category category;

    public Book(String title, double price, Author author, Category category) {
        super(title, price);
        this.author = author;
        this.category = category;
    }


    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String getItemType() {
        return "Book";
    }
}
