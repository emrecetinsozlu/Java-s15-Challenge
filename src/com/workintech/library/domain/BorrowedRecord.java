package com.workintech.library.domain;

import java.time.LocalDateTime;

public class BorrowedRecord {
    private static int recordCounter = 1;
    private int id;
    private final int memberId;
    private final int itemId;
    private final LocalDateTime borrowedAt;
    private LocalDateTime returnedAt;

    public BorrowedRecord(int memberId, int itemId) {
        this.id = recordCounter++;
        this.memberId = memberId;
        this.itemId = itemId;
        this.borrowedAt = LocalDateTime.now();
        this.returnedAt = null;
    }

    public int getId() {
        return id;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getItemId() {
        return itemId;
    }

    public LocalDateTime getBorrowedAt() {
        return borrowedAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public boolean isActive() {
        return returnedAt == null;
    }

    //setReturn time
    public void closeReturn() {
        if (this.returnedAt != null) return; // idempotent: ikinci kez çağrılırsa patlamasın (MVP)
        this.returnedAt = LocalDateTime.now();
    }

}
