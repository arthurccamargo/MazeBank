package com.arthurccamargo.mazebank.service.impl;

import com.arthurccamargo.mazebank.domain.entities.CheckingAccount;
import com.arthurccamargo.mazebank.domain.entities.Client;
import com.arthurccamargo.mazebank.repositories.CheckingAccountRepository;
import com.arthurccamargo.mazebank.repositories.ClientRepository;
import com.arthurccamargo.mazebank.rest.dto.CheckingAccountDTO;
import com.arthurccamargo.mazebank.rest.dto.ClientDTO;
import com.arthurccamargo.mazebank.rest.dto.InfoAccountDTO;
import com.arthurccamargo.mazebank.service.CheckingAccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class CheckingAccountImpl implements CheckingAccountService {

    private final CheckingAccountRepository checkingAccountRepository;
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public CheckingAccount save(CheckingAccountDTO checkingAccountDTO) {
        Long idClient = checkingAccountDTO.getClient();
        Client client = clientRepository
                .findById(idClient)
                .orElseThrow( () ->  new RuntimeException("Invalid Client Code."));

        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setClient(client);
        checkingAccount.setAccountNumber(checkingAccountDTO.getAccountNumber());
        checkingAccount.setBalance(checkingAccountDTO.getBalance());
        checkingAccount.setTransaction_limit(checkingAccountDTO.getTransaction_limit());

        checkingAccountRepository.save(checkingAccount);
        return checkingAccount;
    }

    public InfoAccountDTO findById(Long id) {
        CheckingAccount checkingAccount =  checkingAccountRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(checkingAccount.getClient().getName());
        clientDTO.setCpf(checkingAccount.getClient().getCpf());
        clientDTO.setEmail(checkingAccount.getClient().getEmail());
        clientDTO.setPhone(checkingAccount.getClient().getPhone());

        InfoAccountDTO infoAccountDTO = new InfoAccountDTO();
        infoAccountDTO.setAccountNumber(checkingAccount.getAccountNumber());
        infoAccountDTO.setBalance(checkingAccount.getBalance());
        infoAccountDTO.setTransaction_limit(checkingAccount.getTransaction_limit());
        infoAccountDTO.setClient(clientDTO);

        return infoAccountDTO;
    }
}
