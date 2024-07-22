package com.arthurccamargo.mazebank.service;

import com.arthurccamargo.mazebank.domain.entities.Client;

public interface ClientService {
    Client save(Client client);
    Client findById(Long id);
    void deleteById(Long id);
    void updateById(Long id, Client client);
}
