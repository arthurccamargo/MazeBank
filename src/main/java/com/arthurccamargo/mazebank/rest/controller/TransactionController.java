package com.arthurccamargo.mazebank.rest.controller;

import com.arthurccamargo.mazebank.domain.entities.Transaction;
import com.arthurccamargo.mazebank.rest.dto.TransactionDTO;
import com.arthurccamargo.mazebank.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Long save(@RequestBody TransactionDTO dto) {
        Transaction transaction = service.save(dto);
        return transaction.getId();
    }
}
