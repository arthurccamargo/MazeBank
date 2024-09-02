package com.arthurccamargo.mazebank.service.impl;

import com.arthurccamargo.mazebank.domain.entities.CheckingAccount;
import com.arthurccamargo.mazebank.domain.entities.Client;
import com.arthurccamargo.mazebank.domain.entities.Transaction;
import com.arthurccamargo.mazebank.exception.EqualAccountsException;
import com.arthurccamargo.mazebank.exception.ReceiverAccountException;
import com.arthurccamargo.mazebank.exception.SenderAccountException;
import com.arthurccamargo.mazebank.repositories.CheckingAccountRepository;
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
    private final CheckingAccountRepository checkingAccountRepository;


    @Override
    @Transactional
    public Transaction save(TransactionDTO transactionDTO) {

        // receiver can be sender
        // sender can be receiver also
        Long idSenderAccount = transactionDTO.getSenderAccount();
        CheckingAccount senderAccount = checkingAccountRepository
                .findById(idSenderAccount)
                .orElseThrow(() -> new RuntimeException("Invalid Account Code."));
        // sender is the owner of the senderAccount
        if (senderAccount.getClient().getId() !=  transactionDTO.getSender()){
            System.out.println(senderAccount.getClient().getId());
            System.out.println(transactionDTO.getSender());
            throw new SenderAccountException();
        }

        Long idReceiverAccount = transactionDTO.getReceiverAccount();
        CheckingAccount receiverAccount = checkingAccountRepository
                .findById(idReceiverAccount)
                .orElseThrow( () ->  new RuntimeException("Invalid Account Code."));
        // receiver is the owner of the receiverAccount
        if (receiverAccount.getClient().getId() !=  transactionDTO.getReceiver()){
            throw new ReceiverAccountException();
        }

        // senderAccount must be different from receiverAccount
        if (transactionDTO.getSenderAccount() == transactionDTO.getReceiverAccount()){
            throw new EqualAccountsException();
        }

        Long idSender = transactionDTO.getSender();
        Client sender = clientRepository
                .findById(idSender)
                .orElseThrow( () ->  new RuntimeException("Invalid Client Code."));

        Long idReceiver = transactionDTO.getReceiver();
        Client receiver = clientRepository
                .findById(idReceiver)
                .orElseThrow( () ->  new RuntimeException("Invalid Client Code."));

        //account manipulation
        senderAccount.setBalance(senderAccount.getBalance() - transactionDTO.getAmount());
        receiverAccount.setBalance(receiverAccount.getBalance() + transactionDTO.getAmount());

        // create transaction
        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setSenderAccount(senderAccount);
        transaction.setReceiverAccount(receiverAccount);
        transaction.setDate(LocalDateTime.now());
        transaction.setAmount(transactionDTO.getAmount());

        checkingAccountRepository.save(senderAccount);
        checkingAccountRepository.save(receiverAccount);
        transactionRepository.save(transaction);
        return transaction;
    }
}
