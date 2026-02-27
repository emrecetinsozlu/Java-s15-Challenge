package com.workintech.library.domain;

//Author u Book içerisinde kullandık composition a bir örnek
public class Book extends LibraryItem {
    private String isbn;
    private Author author;
    private Category category;

    public Book(int id, String title, double price, String isbn, Author author, Category category) {
        super(title, id, price);
        this.isbn = isbn;
        this.author = author;
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
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
