package com.servicedesk.api.models;

import com.servicedesk.api.models.e.TicketStatus;

import java.sql.Timestamp;

public class Ticket {
    private long id;
    private String description;
    private User userOpen;
    private User userWork;
    private TicketStatus status;
    private final long createdAt;
    private long updatedAt;

    public Ticket(String description) {
        this.description = description;
        this.createdAt = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public Ticket() {
        this.createdAt = new Timestamp(System.currentTimeMillis()).getTime();
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

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Ticket: " + this.getDescription()
                + " | Created at: " + this.getCreatedAt()
                + " | Created by: " + this.getUserOpen().toString();
    }
}
