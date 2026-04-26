package org.example;

import org.example.dao.hql.ClientHqlDao;
import org.example.dao.hql.TicketHqlDao;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.service.*;
import org.example.util.FlywayMigration;
import org.example.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        FlywayMigration.migrate();

        System.out.println("\n=== MODUL 13 TEST START ===");

        ClientCrudService clientService = new ClientCrudServiceImpl();
        PlanetService planetService = new PlanetServiceImpl();
        TicketCrudService ticketService = new TicketCrudServiceImpl();

        Client client = clientService.create("Alex Test");

        Planet earth = planetService.getById("EARTH");
        if (earth == null) {
            earth = planetService.create("EARTH", "Earth");
        }

        Planet mars = planetService.getById("MARS");
        if (mars == null) {
            mars = planetService.create("MARS", "Mars");
        }

        Ticket ticket = ticketService.createTicket(client, earth, mars);

        System.out.println("\n=== CREATED DATA ===");
        System.out.println(client);
        System.out.println(earth);
        System.out.println(mars);
        System.out.println(ticket);

        ClientHqlDao clientHqlDao = new ClientHqlDao();
        TicketHqlDao ticketHqlDao = new TicketHqlDao();

        System.out.println("\n=== HQL: ALL CLIENTS ===");
        clientHqlDao.getAll().forEach(System.out::println);

        System.out.println("\n=== HQL: CLIENT BY NAME ===");
        clientHqlDao.getByName("Alex").forEach(System.out::println);

        System.out.println("\n=== HQL: TICKETS WITH DETAILS ===");
        ticketHqlDao.getWithDetails().forEach(System.out::println);

        HibernateUtil.shutdown();
    }
}
