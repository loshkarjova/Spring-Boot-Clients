package com.example.app.services;

import com.example.app.entities.Client;
import com.example.app.repositories.ClientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;

    public List<Client> getAllClients() {
        log.info("MY_LOG: ClientService.getAllClients()");
        return repository.findAll();
    }

    public Client getClientById(Long id) {
        log.info("MY_LOG: ClientService.getClientById(Long id). ID: " + id);
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Client saveOrUpdate(Client client) {
        log.info("MY_LOG: ClientService.saveOrUpdate(Client client). Save ID: " + client.getId() +
                ", First Name: " + client.getFirstName()
                + ", Last Name: " + client.getLastName() + ",Phone " + client.getPhone());
        return repository.save(client);
    }

    public void deleteClientById(Long id) {
        log.info("MY_LOG: Client.Service.deleteClientById(Long id). ID: " + id);
        repository.deleteById(id);
    }


}
