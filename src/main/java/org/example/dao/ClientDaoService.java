package org.example.dao;

import org.example.entity.Client;
import java.util.List;

public interface ClientDaoService {

    void save(Client client);

    Client getById(Long id);

    List<Client> getAll();

    void update(Client client);

    void delete(Client client);
}
