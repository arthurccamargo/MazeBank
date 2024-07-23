package com.arthurccamargo.mazebank.service.impl;

import com.arthurccamargo.mazebank.domain.entities.Client;
import com.arthurccamargo.mazebank.domain.entities.Transaction;
import com.arthurccamargo.mazebank.repositories.ClientRepository;
import com.arthurccamargo.mazebank.repositories.TransactionRepository;
import com.arthurccamargo.mazebank.rest.dto.TransactionDTO;
import com.arthurccamargo.mazebank.service.TransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;


    @Override
    @Transactional
    public Transaction save(TransactionDTO transactionDTO) {
        Long idSender = transactionDTO.getSender();
        Client sender = clientRepository
                .findById(idSender)
                .orElseThrow( () ->  new RuntimeException("Invalid Client Code."));

        Long idReceiver = transactionDTO.getReceiver();
        Client receiver = clientRepository
                .findById(idReceiver)
                .orElseThrow( () ->  new RuntimeException("Invalid Client Code."));

        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setDate(LocalDateTime.now());
        transaction.setAmount(transactionDTO.getAmount());

        transactionRepository.save(transaction);
        return transaction;
    }
}
