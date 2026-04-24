package org.example.service;

import org.example.entity.Planet;

import java.util.List;

public interface PlanetService {

    Planet create(String id, String name);

    Planet getById(String id);

    List<Planet> getAll();

    void update(String id, String name);

    void delete(String id);
}
