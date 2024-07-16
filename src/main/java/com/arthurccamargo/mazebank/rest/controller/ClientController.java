package com.arthurccamargo.mazebank.rest.controller;

import com.arthurccamargo.mazebank.domain.entities.Client;
import com.arthurccamargo.mazebank.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {this.clientRepository = clientRepository;}

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Client getClienteById( @PathVariable Integer id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente Nao Encontrado"));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Client save( @RequestBody Client client) {
        return clientRepository.save(client);
    }


}
