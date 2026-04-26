package org.example.service;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;

import java.util.List;

public interface TicketCrudService {

    Ticket createTicket(Client client, Planet from, Planet to);

    Ticket getById(Long id);

    List<Ticket> getAll();

    void delete(Ticket ticket);
}
