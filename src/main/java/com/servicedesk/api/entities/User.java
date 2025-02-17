package com.servicedesk.api.entities;

import com.servicedesk.api.entities.dto.CreateUserDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = true, length = 125)
    private String name;

    @Column(name = "email", unique = true, nullable = false, length = 125)
    private String email;

    @Column(name = "password", nullable = true, length = 255)
    private String password;

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "userOpen")
    private List<Ticket> ticketsOpen;

    @OneToMany(mappedBy = "userWork")
    private List<Ticket> ticketsWork;

    public User() {
        this.createdAt = LocalDateTime.now();
    }

    public User(String email) {
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    public User(CreateUserDto dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.password = dto.password();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Ticket> getTicketsOpen() {
        return ticketsOpen;
    }

    public void setTicketsOpen(List<Ticket> ticketsOpen) {
        this.ticketsOpen = ticketsOpen;
    }

    public List<Ticket> getTicketsWork() {
        return ticketsWork;
    }

    public void setTicketsWork(List<Ticket> ticketsWork) {
        this.ticketsWork = ticketsWork;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " | Email: " + this.getEmail();
    }
}
