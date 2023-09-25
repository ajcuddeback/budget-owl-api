package com.budgetOwl.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String subscriptionId;
    @Column(unique = true, nullable = false)
    private String fwid;

    private Users() {}
    public Users(String subscriptionId, String fwid) {
        this.subscriptionId = subscriptionId;
        this.fwid = fwid;
    }

    public UUID getId() {
        return this.id;
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public String getFwid() {
        return this.fwid;
    }
}
