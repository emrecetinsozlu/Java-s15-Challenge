package com.workintech.library.service;

import com.workintech.library.domain.BorrowedRecord;
import com.workintech.library.domain.LibraryItem;
import com.workintech.library.domain.Member;
import com.workintech.library.domain.ItemStatus;
import com.workintech.library.repository.LibraryRepository;

public class BorrowService {

    private final LibraryRepository libraryRepository;
    //private final BillingService billingService;

    public BorrowService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
        //this.billingService = billingService;
    }

    public BorrowedRecord borrowItem(int memberId, int itemId) {
        //KULLANICI BULUNAMAZSA NERDE HATA VERDİRELİM?
        Member member = libraryRepository.findMemberById(memberId);
        LibraryItem item = libraryRepository.findItemById(itemId);

        // 1) Item uygun mu?
        if (item.getStatus() == ItemStatus.BORROWED) {
            System.out.println("Item is not borrowed");
            return null;
        }

        // 2) Item başkasında mı? (aktif record var mı)
        BorrowedRecord activeRecord = libraryRepository.findActiveRecordByItemId(itemId);
        if (activeRecord != null) {
            System.out.println("Record already exists, Item already borrowed");
            return null;
        }

        // 3) Member limit kontrol
        if (member.getBorrowedItems().size() >= member.getBorrowedLimit()) {
            System.out.println("Member Borrowed limit exceeded");
            return null;
        }

        // 4) Record oluştur
        BorrowedRecord record = new BorrowedRecord(memberId, itemId);
        libraryRepository.saveBorrowRecord(record);

        // 5) State update (composition + OOP)
        item.markBorrowed();
        member.addBorrowedItem(item); // borrowedItems Set içine eklesin
        System.out.println("Borrowed item added");
        // 6) Billing
        //billingService.charge(record, item, member);

        return record;
    }

    public void returnItem(int memberId, int itemId) {
        Member member = libraryRepository.findMemberById(memberId);
        LibraryItem item = libraryRepository.findItemById(itemId);
        System.out.println(itemId);
        BorrowedRecord active = libraryRepository.findActiveRecordByItemId(itemId);
        if (active == null) {
            //throw new IllegalStateException("No active borrow record for this item.");
            System.out.println("Item is not available");
            return;
        }

        // Güvenlik: bu item bu member'da mı?
        if (active.getMemberId() != memberId) {
            //throw new IllegalStateException("");
            System.out.println("This item is borrowed by another member.");
            return;
        }

        // 1) record kapat
        active.closeReturn();
        // 2) state update
        item.markReturned();
        member.removeBorrowedItem(item); // borrowedItems Set'ten silsin
        System.out.println("Item is returned");
        // 3) billing refund
        //billingService.refund(active, item, member);
    }




 /*
    private Member requireMember(int memberId) {

        //if (m == null) throw new IllegalArgumentException("Member not found: " + memberId);
        return m;
    }

    private LibraryItem requireItem(int itemId) {
        LibraryItem i = libraryRepository.findItemById(itemId);
        if (i == null) throw new IllegalArgumentException("Item not found: " + itemId);
        return i;
    }
    */

}