package org.example.dao;

import org.example.entity.Ticket;
import java.util.List;

public interface TicketDaoService {

    void save(Ticket ticket);

    Ticket getById(Long id);

    List<Ticket> getAll();

    void delete(Ticket ticket);
}
