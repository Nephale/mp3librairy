package com.hoc.libraryfx.model;

import java.util.UUID;

public class Author {
    private final UUID id;
    private final String firstName;
    private final String lastName;

    public Author(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
