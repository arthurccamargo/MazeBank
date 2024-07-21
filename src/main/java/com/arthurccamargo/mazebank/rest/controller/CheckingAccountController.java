package com.arthurccamargo.mazebank.rest.controller;

import com.arthurccamargo.mazebank.domain.entities.CheckingAccount;
import com.arthurccamargo.mazebank.rest.dto.CheckingAccountDTO;
import com.arthurccamargo.mazebank.service.CheckingAccountService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/account")
public class CheckingAccountController {
    private CheckingAccountService service;

    public CheckingAccountController(CheckingAccountService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Long save(@RequestBody CheckingAccountDTO dto) {
        CheckingAccount checkingAccount = service.save(dto);
        return checkingAccount.getId();
    }

    @GetMapping("{id}")
    public CheckingAccount getById(@PathVariable Long id) {
        return service
                .getById(id);
    }
}
