package com.workintech.library.app;

import com.workintech.library.domain.*;
import com.workintech.library.repository.LibraryRepository;
import com.workintech.library.service.BorrowService;

import java.util.*;

public class ConsoleHandlers {
    private final Scanner scanner;
    private final LibraryRepository libraryRepository;
    private final BorrowService borrowService;

    public ConsoleHandlers(Scanner scanner, LibraryRepository libraryRepository, BorrowService borrowService) {
        this.scanner = scanner;
        this.libraryRepository = libraryRepository;
        this.borrowService = borrowService;
    }
    // ConsoleUygulamalarında Integer.parseInt(scanner.nextLine()); şeklinde sayısal değer almaya dikkat et
    public void addBook(){
        System.out.println("Enter Book Title");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter Book Author");
        String bookAuthor = scanner.nextLine();
        Author author = libraryRepository.createAuthor(bookAuthor);
        System.out.println("Enter Book Price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Choose a Category");
        Category.printCategories();
        Category category = Category.getCategory(Integer.parseInt(scanner.nextLine()));
        Book book = new Book(bookTitle,price,author,category);
        libraryRepository.addItem(book);
        System.out.println("Book Added");
        ArrayList<LibraryItem> items = libraryRepository.getAllItems();
        for(LibraryItem item : items){
            System.out.println(item.toString());
        }
    }

    public void removeBook() {
        LibraryItem selectedItem = chooseLibraryItem();
        libraryRepository.removeItem(selectedItem.getId());
    }

    public void addMember(){
        System.out.println("Member tipi seç:");
        System.out.println("1 - Student");
        System.out.println("2 - Faculty");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.print("İsim: ");
        String name = scanner.nextLine();
        Member member = (type == 1) ? new Student(name) : new Faculty(name);
        libraryRepository.addMember(member);
        System.out.println("Member eklendi.");

    }
    public void borrowItem(){
        Member selectedMember = chooseMember();
        LibraryItem selectedItem = chooseLibraryItem();
        borrowService.borrowItem(selectedMember.getId(),selectedItem.getId());

    }

    public void returnItem(Member member){
        ArrayList<LibraryItem> borrowedList = new ArrayList<>(member.getBorrowedItems());
        if (borrowedList.isEmpty()) {
            System.out.println(" *** Üyenin aldığı kitap yok. ***");
            return;
        }

        System.out.println("İade edilecek kitabı seç:");

        for (int i = 0; i < borrowedList.size(); i++) {
            LibraryItem item = borrowedList.get(i);
            System.out.println((i + 1) + " - " + item.getTitle() + " - " + item.getId());
        }
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > borrowedList.size()) {
            System.out.println("Geçersiz seçim");
        }

        borrowService.returnItem(member.getId(),choice);
    }

    public Member chooseMember(){
        ArrayList<Member> members = libraryRepository.getAllMembers();
        if(members.isEmpty()){
            System.out.println("Kayıtlı Hiç Kullanıcı Yok");
            return null;
        }
        for (int i = 0; i < members.size(); i++) {
            Member m = members.get(i);
            System.out.println((i + 1) + " - " + m.getName());
        }
        System.out.println("Bir Kullanıcı Seçin");
        int memberChoice = Integer.parseInt(scanner.nextLine());;
        if(memberChoice < 1 || memberChoice > members.size()){
            System.out.println("Kullanıcı Seçimi Hatalı");
            return null;
        }
        Member selectedMember = members.get(memberChoice - 1);
        return selectedMember;
    }
    public LibraryItem chooseLibraryItem(){
        ArrayList<LibraryItem> items = libraryRepository.getAllAvailableItems();
        if(items.isEmpty()){
            System.out.println("No items available");
            return null;
        }
        System.out.println("Item girin");
        for(int i = 0; i < items.size(); i++){
            LibraryItem item = items.get(i);
            System.out.println(i + 1 + " - " + item.toString());
        }
        int itemChoice = Integer.parseInt(scanner.nextLine());;
        LibraryItem selectedItem = items.get(itemChoice - 1);
        return selectedItem;
    }

    public void mainMenuLoop() {
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1 - Member ekle");
            System.out.println("2 - Member Seç");
            System.out.println("0 - Çıkış");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addMember();
                case "2" -> bookMenuLoop();
                case "0" -> { return; } // geri
                default -> System.out.println("Geçersiz seçim");
            }
        }
    }
   public void bookMenuLoop() {
       Member member = chooseMember();
       if(member == null) return;
       while (true) {
           System.out.println("\n--- BOOK MENU ---");
           System.out.println("1 - Kitap ekle");
           System.out.println("2 - Kitap Sil");
           System.out.println("3 - Kitap Ödünç Al");
           System.out.println("4 - Kitap İade Et");
           System.out.println("0 - Geri");

           String choice = scanner.nextLine();
           switch (choice) {
               case "1" :
                   addBook();
                   break;
               case "2" :
                   removeBook();
                   break;
               case "3" :
                   borrowItem();
                   break;
               case "4" :
                   returnItem(member);
                   break;
               case "0" : {
                   return;
               } // geri
               default :
                   System.out.println("Geçersiz seçim");
           }
       }
   }
}
