package com.workintech.library.repository;




// Bu sınıfımızda kütüphanedeki veri saklama kısmını halledeceğiz
// Kitapları Map kullanarak saklayacağız(Map'ler key value pair şeklinde veri tutmamızı sağlıyor.)
//Veri erişiminde tüm listeyi dolaşmayıp doğrudan anahtara gittiği için HIZLIDIRLAR

import com.workintech.library.domain.LibraryItem;

public class LibraryRepository {
    private Map<Integer, LibraryItem> items = new HashMap<>();
    private Map<Integer, Member> members = new HashMap<>();
    private Set<>
}
