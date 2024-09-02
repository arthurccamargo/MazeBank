package com.arthurccamargo.mazebank.service.impl;

import com.arthurccamargo.mazebank.domain.entities.Client;
import com.arthurccamargo.mazebank.repositories.ClientRepository;
import com.arthurccamargo.mazebank.rest.dto.ClientDTO;
import com.arthurccamargo.mazebank.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public ClientDTO findById(Long id) {
        Client client = clientRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setCpf(client.getCpf());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPhone(client.getPhone());
        return clientDTO;
    }

    @Override
    public void deleteById(Long id) {
        clientRepository
                .findById(id)
                .map( client -> {
                    clientRepository.delete(client);
                    return Void.class;})
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Client Not Found"));
    }

    @Override
    public void updateById(Long id, Client client) {
        clientRepository
                .findById(id)
                .map(clientDatabase -> {
                    client.setId(clientDatabase.getId());
                    clientRepository.save(client);
                    return client;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Client Not Found"));
    }
}
