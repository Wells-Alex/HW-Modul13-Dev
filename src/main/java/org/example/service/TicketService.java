package org.example.service;

import org.example.dao.TicketDao;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public class TicketService {

    private final TicketDao ticketDao = new TicketDao();

    public Ticket createTicket(Client client, Planet from, Planet to) {

        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }

        if (from == null || to == null) {
            throw new IllegalArgumentException("Planet cannot be null");
        }

        if (client.getId() == null) {
            throw new IllegalArgumentException("Client must exist in DB");
        }

        if (from.getId() == null || to.getId() == null) {
            throw new IllegalArgumentException("Planet must exist in DB");
        }

        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setFromPlanet(from);
        ticket.setToPlanet(to);
        ticket.setCreatedAt(LocalDateTime.now());

        ticketDao.save(ticket);

        return ticket;
    }

    public Ticket getById(Long id) {
        return ticketDao.getById(id);
    }

    public List<Ticket> getAll() {
        return ticketDao.getAll();
    }

    public void delete(Ticket ticket) {
        if (ticket == null || ticket.getId() == null) {
            throw new IllegalArgumentException("Ticket must exist");
        }
        ticketDao.delete(ticket);
    }
}
