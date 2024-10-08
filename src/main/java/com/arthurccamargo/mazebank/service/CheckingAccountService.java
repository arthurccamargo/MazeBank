package com.arthurccamargo.mazebank.service;

import com.arthurccamargo.mazebank.domain.entities.CheckingAccount;
import com.arthurccamargo.mazebank.rest.dto.CheckingAccountDTO;
import com.arthurccamargo.mazebank.rest.dto.InfoAccountDTO;

public interface CheckingAccountService {
    CheckingAccount save(CheckingAccountDTO checkingAccountDTO);

    InfoAccountDTO findById(Long id);
}
