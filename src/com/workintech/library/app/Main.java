package com.workintech.library.app;
import com.workintech.library.domain.Student;
public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "John");
        System.out.println(student.getName());
        System.out.println("Hello world!");
    }
}






// Projemiz app folder bizim uygulamamızın giriş noktası olacak. O yüzden Main i buraya taşıdık.