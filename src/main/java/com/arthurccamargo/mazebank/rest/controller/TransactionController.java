package com.arthurccamargo.mazebank.rest.controller;

import com.arthurccamargo.mazebank.domain.entities.CheckingAccount;
import com.arthurccamargo.mazebank.domain.entities.Transaction;
import com.arthurccamargo.mazebank.exception.OutOfLimitException;
import com.arthurccamargo.mazebank.rest.dto.InfoAccountDTO;
import com.arthurccamargo.mazebank.rest.dto.TransactionDTO;
import com.arthurccamargo.mazebank.service.CheckingAccountService;
import com.arthurccamargo.mazebank.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService service;
    private final CheckingAccountService checkingAccountService;

    public TransactionController(TransactionService service, CheckingAccountService checkingAccountService) {
        this.service = service;
        this.checkingAccountService = checkingAccountService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Long save(@RequestBody TransactionDTO dto) {
        Long checkingSenderAccount =  dto.getSenderAccount();
        InfoAccountDTO infoAccountDTO = checkingAccountService.findById(checkingSenderAccount);

        if(checkLimit(dto.getAmount(), infoAccountDTO.getTransaction_limit())) {
            Transaction transaction = service.save(dto);
            return transaction.getId();
        }
        else {
            throw new OutOfLimitException();
        }
    }

    private boolean checkLimit(Double amount, Integer limit) {
        return amount <= limit;
    }
}

