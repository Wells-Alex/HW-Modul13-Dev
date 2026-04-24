package org.example.dao.hql;

import org.example.entity.Client;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ClientHqlDao {

    public List<Client> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }

    public Client getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Client.class, id);
        }
    }

    public List<Client> getByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "from Client c where c.name like :name", Client.class)
                    .setParameter("name", "%" + name + "%")
                    .list();
        }
    }
}
