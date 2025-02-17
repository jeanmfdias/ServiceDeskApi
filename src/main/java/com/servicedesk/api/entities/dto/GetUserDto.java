package com.servicedesk.api.entities.dto;

import com.servicedesk.api.entities.Ticket;
import com.servicedesk.api.entities.User;

import java.util.List;

public record GetUserDto(String name, String email, List<Ticket> ticketsOpen, List<Ticket> ticketsWork) {
    public GetUserDto(User user) {
        this(user.getName(), user.getEmail(), user.getTicketsOpen(), user.getTicketsWork());
    }
}
