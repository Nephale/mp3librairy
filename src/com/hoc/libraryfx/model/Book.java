package com.hoc.libraryfx.model;

import java.util.UUID;

public class Book {
    private final UUID id;
    private final UUID authorId;
    private final String isbn13;
    private final String title;
    private final String summary;

    public Book(UUID id, UUID authorId, String isbn13, String title, String summary) {
        this.id = id;
        this.authorId = authorId;
        this.isbn13 = isbn13;
        this.title = title;
        this.summary = summary;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }
}
