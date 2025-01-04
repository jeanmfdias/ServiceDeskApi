package com.servicedesk.api.entities;

import com.servicedesk.api.entities.e.TicketStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_sequence", allocationSize = 1)
    private LocalDateTime id;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Transient
    private User userOpen;

    @Transient
    private User userWork;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    public Ticket(String description) {
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    public Ticket() {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getId() {
        return id;
    }

    public void setId(LocalDateTime id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUserOpen() {
        return userOpen;
    }

    public void setUserOpen(User userOpen) {
        this.userOpen = userOpen;
    }

    public User getUserWork() {
        return userWork;
    }

    public void setUserWork(User userWork) {
        this.userWork = userWork;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Ticket: " + this.getDescription()
                + " | Created at: " + this.getCreatedAt()
                + " | Created by: " + this.getUserOpen().toString();
    }
}
