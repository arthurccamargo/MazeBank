package com.arthurccamargo.mazebank.service;

import com.arthurccamargo.mazebank.domain.entities.Transaction;
import com.arthurccamargo.mazebank.rest.dto.TransactionDTO;

public interface TransactionService {
    Transaction save(TransactionDTO transaction);
}
