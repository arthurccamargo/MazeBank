package com.arthurccamargo.mazebank.repositories;

import com.arthurccamargo.mazebank.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
