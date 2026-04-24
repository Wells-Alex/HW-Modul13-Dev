package org.example.dao.hql;

import org.example.entity.Planet;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class PlanetHqlDao {

    public List<Planet> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

    public Planet getById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Planet.class, id);
        }
    }
}
