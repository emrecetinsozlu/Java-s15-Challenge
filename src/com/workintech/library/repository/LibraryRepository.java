package com.workintech.library.repository;




// Bu sınıfımızda kütüphanedeki veri saklama kısmını halledeceğiz
// Kitapları Map kullanarak saklayacağız(Map'ler key value pair şeklinde veri tutmamızı sağlıyor.)
//Veri erişiminde tüm listeyi dolaşmayıp doğrudan anahtara gittiği için HIZLIDIRLAR


import com.workintech.library.domain.*;
import java.util.*;

public class LibraryRepository {
    private Map<Integer, LibraryItem> items = new HashMap<>();
    private Map<Integer,Author> authors = new HashMap<>();
    private Map<Integer, Member> members = new HashMap<>();
    private Set<Category> availableCategories = new HashSet<>();
    // hangi kitaplar hangi kullanıcıda
    private Map<Integer, BorrowedRecord> borrowedRecords = new HashMap<>();

    // ITEM OPERATION
    public void addItem(LibraryItem item) {
        items.put(item.getId(), item);
        if (item instanceof Book book) {
            availableCategories.add(book.getCategory());
        }
    }

    public LibraryItem findItemById(int id) {
        return items.get(id);
    }

    public void removeItem(int id) {
        LibraryItem item = items.get(id);
        if (item.isAvailable()) {
            items.remove(id);
        } else {
            System.out.println("Item is borrowed");
        }
    }

    public ArrayList<LibraryItem> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public ArrayList<LibraryItem> getAllAvailableItems() {
        ArrayList<LibraryItem> availableItems = new ArrayList<>();
        for (LibraryItem item : items.values()) {
            if (item.isAvailable()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    public ArrayList<Book> getAllItemsByAuthor(String authorName) {
        ArrayList<Book> itemsByAuthor = new ArrayList<>();
        for (LibraryItem item : items.values()) {
            if(item instanceof Book){
                Book book = (Book) item;
                if(book.getAuthor().equals(authorName)){
                    itemsByAuthor.add(book);
                }
            }
        }
        return itemsByAuthor;
    }

  // AUTHOR OPERATIONS

    public Author createAuthor(String authorName){
        Author author = authors.get(authorName);
        if(author == null){
            author = new Author(authorName);
            authors.put(author.getId(), author);
        }
        return author;
    }

  //MEMBER OPERATIONS   ---------------------------

    public void addMember(Member member) {
          members.put(member.getId(), member);
    }

    public Member findMemberById(int id) {
        return members.get(id);
    }

    public ArrayList<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }


    // ---------------- CATEGORY OPERATIONS ----------------

    public Set<Category> getAvailableCategories() {
        return availableCategories;
    }

    // BORROW OPERATIONS
    public BorrowedRecord findActiveRecordByItemId(int itemId) {
        return borrowedRecords.get(itemId);
    }
    // kayıt oluştur
    public void saveBorrowRecord(BorrowedRecord record) {
        borrowedRecords.put(record.getItemId(), record);
    }

    public void removeBorrowRecord(int itemId) {
        borrowedRecords.remove(itemId);
    }



}