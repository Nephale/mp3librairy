package com.hoc.libraryfx.model;

import java.time.LocalDate;
import java.util.UUID;

public class Adherent {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final boolean subscriptionPaid;

    public Adherent(UUID id, String firstName, String lastName, LocalDate birthday, boolean subscriptionPaid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.subscriptionPaid = subscriptionPaid;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean isSubscriptionPaid() {
        return subscriptionPaid;
    }
}
