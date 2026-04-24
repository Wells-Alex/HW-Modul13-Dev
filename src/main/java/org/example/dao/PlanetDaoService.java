package org.example.dao;

import org.example.entity.Planet;

import java.util.List;

public interface PlanetDaoService {

    void save(Planet planet);

    Planet getById(String id);

    List<Planet> getAll();

    void update(Planet planet);

    void delete(Planet planet);
}
