package org.example.service;

import org.example.entity.Client;
import java.util.List;

public interface ClientCrudService {

    Client create(String name);

    Client getById(Long id);

    List<Client> getAll();

    Client update(Long id, String name);

    void delete(Long id);
}
