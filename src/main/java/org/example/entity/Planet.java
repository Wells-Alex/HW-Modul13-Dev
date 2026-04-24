package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "fromPlanet")
    private List<Ticket> departureTickets;

    @OneToMany(mappedBy = "toPlanet")
    private List<Ticket> arrivalTickets;

    public Planet() {}

    public String getId() { return id; }

    public String getName() { return name; }

    public List<Ticket> getDepartureTickets() { return departureTickets; }

    public List<Ticket> getArrivalTickets() { return arrivalTickets; }

    public void setName(String name) { this.name = name; }

    public void setId(String id) { this.id = id; }

    @Override
    public String toString() {
        return id + " | " + name;
    }
}
