package org.example.service;

import org.example.dao.ClientDaoService;
import org.example.dao.ClientDaoServiceImpl;
import org.example.entity.Client;

import java.util.List;

public class ClientCrudServiceImpl implements ClientCrudService {

    private final ClientDaoService dao = new ClientDaoServiceImpl();

    // CREATE
    @Override
    public Client create(String name) {
        Client client = new Client();
        client.setName(name);

        dao.save(client);
        return client;
    }

    // READ
    @Override
    public Client getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public List<Client> getAll() {
        return dao.getAll();
    }

    // UPDATE
    @Override
    public Client update(Long id, String name) {
        Client client = dao.getById(id);

        if (client != null) {
            client.setName(name);
            dao.update(client);
        }

        return client;
    }

    // DELETE
    @Override
    public void delete(Long id) {
        Client client = dao.getById(id);
        if (client != null) {
            dao.delete(client);
        }
    }
}
