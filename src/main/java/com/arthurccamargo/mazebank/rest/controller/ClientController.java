package com.arthurccamargo.mazebank.rest.controller;

import com.arthurccamargo.mazebank.domain.entities.Client;
import com.arthurccamargo.mazebank.rest.dto.ClientDTO;
import com.arthurccamargo.mazebank.service.ClientService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {this.service = service;}

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ClientDTO getById(@PathVariable Long id) {
        return service
                .findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Client save( @RequestBody Client client) {
        return service.save(client);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update( @PathVariable("id") Long id, @RequestBody Client client) {
        service.updateById(id, client);
    }
}
