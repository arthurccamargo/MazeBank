package com.arthurccamargo.mazebank.repositories;

import com.arthurccamargo.mazebank.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
