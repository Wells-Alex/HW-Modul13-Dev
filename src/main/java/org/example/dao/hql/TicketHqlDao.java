package org.example.dao.hql;

import org.example.entity.Ticket;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TicketHqlDao {

    public List<Ticket> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    public Ticket getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Ticket.class, id);
        }
    }

    public List<Ticket> getWithDetails() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("""
                select distinct t from Ticket t
                join fetch t.client
                join fetch t.fromPlanet
                join fetch t.toPlanet
            """, Ticket.class).list();
        }
    }

    public List<Ticket> getByClientId(Long clientId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "from Ticket t where t.client.id = :id", Ticket.class)
                    .setParameter("id", clientId)
                    .list();
        }
    }

    public List<Ticket> getByPlanet(String planetId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("""
                    from Ticket t
                    where t.fromPlanet.id = :pid
                       or t.toPlanet.id = :pid
                    """, Ticket.class)
                    .setParameter("pid", planetId)
                    .list();
        }
    }
}