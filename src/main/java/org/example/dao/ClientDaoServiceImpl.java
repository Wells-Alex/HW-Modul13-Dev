package org.example.dao;

import org.example.entity.Client;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.function.Consumer;

public class ClientDaoServiceImpl implements ClientDaoService {

    @Override
    public void save(Client client) {
        execute(session -> session.persist(client));
    }

    @Override
    public Client getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Client.class, id);
        }
    }

    @Override
    public List<Client> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }

    @Override
    public void update(Client client) {
        execute(session -> session.merge(client));
    }

    @Override
    public void delete(Client client) {
        execute(session -> {
            Client managed = session.merge(client);
            session.remove(managed);
        });
    }

    private void execute(Consumer<Session> action) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            action.accept(session);

            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        }
    }
}
