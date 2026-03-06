package com.workintech.library.app;
import com.workintech.library.domain.*;
import com.workintech.library.repository.LibraryRepository;
import com.workintech.library.service.BorrowService;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        LibraryRepository libraryRepository = new LibraryRepository();
        BorrowService borrowService = new BorrowService(libraryRepository);
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        ConsoleHandlers consoleHandlers = new ConsoleHandlers(scanner,libraryRepository,borrowService);
        consoleHandlers.mainMenuLoop();



    }
}






// Projemiz app folder bizim uygulamamızın giriş noktası olacak. O yüzden Main i buraya taşıdık.