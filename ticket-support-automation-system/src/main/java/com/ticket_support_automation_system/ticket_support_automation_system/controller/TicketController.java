package com.ticket_support_automation_system.ticket_support_automation_system.controller;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Ticket;
import com.ticket_support_automation_system.ticket_support_automation_system.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //get all Tickets
    @GetMapping("/allTickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.FindAllTickets();
        System.out.print("All tickets: ");
        return ResponseEntity.ok(tickets);
    }

    // add tickets from postman
    @PostMapping("/postmanAddTicket")
    public ResponseEntity<List<Ticket>> addTicket(@RequestBody List<Ticket> tickets) {
        try {
            List<Ticket> saveTickets = ticketService.AddTickets(tickets);
            System.out.print("Save tickets: " + saveTickets);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveTickets);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    // find ticket by ID
    @GetMapping("/findTicket/{id}")
    public ResponseEntity<Ticket> findTicketById(@PathVariable Long id) {
        Ticket ticketId = ticketService.FindTicketById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketId);
    }

}
