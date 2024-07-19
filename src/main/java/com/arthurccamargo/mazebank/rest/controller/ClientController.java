package com.arthurccamargo.mazebank.rest.controller;

import com.arthurccamargo.mazebank.domain.entities.Client;
import com.arthurccamargo.mazebank.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {this.clientRepository = clientRepository;}

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Client getClienteById( @PathVariable Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Client Not Found"));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Client save( @RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clientRepository
                .findById(id)
                .map( client -> {
                    clientRepository.delete(client);
                    return Void.class;})
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Client Not Found"));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update( @PathVariable("id") Long id, @RequestBody Client client) {
        clientRepository
                .findById(id)
                .map(clientDatabase -> {
                    client.setId(clientDatabase.getId());
                    clientRepository.save(client);
                    return client;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Client Not Found"));
    }
}
