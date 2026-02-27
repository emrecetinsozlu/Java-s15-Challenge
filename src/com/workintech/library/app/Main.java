package com.workintech.library.app;
import com.workintech.library.domain.Author;
import com.workintech.library.domain.Book;
import com.workintech.library.domain.Category;
import com.workintech.library.domain.Student;

public class Main {
    public static void main(String[] args) {
        Author author = new Author(100, "George Orwell");
        Book book = new Book(1, "1984", 50.0, "978-0451524935", author, Category.FICTION);

        System.out.println(book.getTitle() + " | " + book.getCategory());
    }
}






// Projemiz app folder bizim uygulamamızın giriş noktası olacak. O yüzden Main i buraya taşıdık.