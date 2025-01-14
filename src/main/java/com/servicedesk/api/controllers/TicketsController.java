package com.servicedesk.api.controllers;

import com.servicedesk.api.entities.Ticket;
import com.servicedesk.api.repositories.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketsController {
    private TicketRepository ticketRepository;

    public TicketsController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Ticket>> getAll() {
        List<Ticket> tickets = this.ticketRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tickets);
    }
}
