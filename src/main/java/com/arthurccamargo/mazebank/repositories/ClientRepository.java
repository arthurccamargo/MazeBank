package com.arthurccamargo.mazebank.repositories;

import com.arthurccamargo.mazebank.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
