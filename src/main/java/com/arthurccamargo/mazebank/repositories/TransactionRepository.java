package com.arthurccamargo.mazebank.repositories;

import com.arthurccamargo.mazebank.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
