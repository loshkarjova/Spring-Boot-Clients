package com.example.app.controllers;

import com.example.app.entities.Client;
import com.example.app.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService service;

    @GetMapping
    public List<Client> getAllClients() {
        log.info("MY_LOG: ClientController.getAllClients()");
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        log.info("MY_LOG: ClientController.getClient(Long id). ID: " + id);
        return ResponseEntity.ok(service.getClientById(id));
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        log.info("MY_LOG: ClientController.addClient(Client client). Add ID: " + client.getId() +
                ", First Name: " + client.getFirstName()
                + ", Last Name: " + client.getLastName() + ",Phone " + client.getPhone());
        return service.saveOrUpdate(client);
    }

    @PutMapping
    public Client updateClient (@RequestBody Client client) {
        log.info("MY_LOG: ClientController.updateClient(Client client). Update: " +
                client.getFirstName());
        return service.saveOrUpdate(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById (@PathVariable("id") Long id){
        log.info("MY_LOG: ClientController.deleteClientById(Long id). Id: " + id);
        service.deleteClientById(id);
    }
}
