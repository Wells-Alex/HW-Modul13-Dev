package org.example.service;

import org.example.dao.PlanetDaoService;
import org.example.dao.PlanetDaoServiceImpl;
import org.example.entity.Planet;

import java.util.List;

public class PlanetServiceImpl implements PlanetService {

    private final PlanetDaoService dao = new PlanetDaoServiceImpl();

    @Override
    public Planet create(String id, String name) {

        Planet existing = dao.getById(id);
        if (existing != null) {
            System.out.println("⚠ Planet already exists: " + id);
            return existing;
        }

        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);

        dao.save(planet);
        return planet;
    }

    @Override
    public Planet getById(String id) {
        return dao.getById(id);
    }

    @Override
    public List<Planet> getAll() {
        return dao.getAll();
    }

    @Override
    public void update(String id, String name) {
        Planet planet = dao.getById(id);
        planet.setName(name);
        dao.update(planet);
    }

    @Override
    public void delete(String id) {
        Planet planet = dao.getById(id);
        dao.delete(planet);
    }
}
