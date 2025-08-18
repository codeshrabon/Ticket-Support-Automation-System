package com.ticket_support_automation_system.ticket_support_automation_system.service;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Ticket;
import com.ticket_support_automation_system.ticket_support_automation_system.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private final TicketRepository ticketRepository;


    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    // get all the tickets
    public List<Ticket> FindAllTickets() {
        return ticketRepository.findAll();
    }

    // add ticket from postman
    public List<Ticket> AddTickets(List<Ticket> tickets) {
        return ticketRepository.saveAll(tickets);
    }


    public Ticket FindTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket ID: " + id + " not found"));
    }
}
