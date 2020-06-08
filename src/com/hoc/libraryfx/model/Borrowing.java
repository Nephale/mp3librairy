package com.hoc.libraryfx.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Borrowing {
    private final UUID id;
    private final UUID bookId;
    private final UUID adherentId;
    private final LocalDateTime dateTime;

    public Borrowing(UUID id, UUID bookId, UUID adherentId, LocalDateTime dateTime) {
        this.id = id;
        this.bookId = bookId;
        this.adherentId = adherentId;
        this.dateTime = dateTime;
    }

    public UUID getId() {
        return id;
    }

    public UUID getBookId() {
        return bookId;
    }

    public UUID getAdherentId() {
        return adherentId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
