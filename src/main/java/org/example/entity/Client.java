package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;

    public Client() {}

    public Long getId() { return id; }

    public String getName() { return name; }

    public List<Ticket> getTickets() { return tickets; }

    public void setName(String name) { this.name = name; }

    public void setId(Long id) { this.id = id; }

    @Override
    public String toString() {
        return id + " | " + name;
    }
}
