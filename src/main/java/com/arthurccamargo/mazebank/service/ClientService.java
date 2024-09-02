package com.arthurccamargo.mazebank.service;

import com.arthurccamargo.mazebank.domain.entities.Client;
import com.arthurccamargo.mazebank.rest.dto.ClientDTO;

public interface ClientService {
    Client save(Client client);
    ClientDTO findById(Long id);
    void deleteById(Long id);
    void updateById(Long id, Client client);
}
