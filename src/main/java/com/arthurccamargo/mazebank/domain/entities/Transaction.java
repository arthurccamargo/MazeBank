package com.arthurccamargo.mazebank.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Client sender;
    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private CheckingAccount senderAccount;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Client receiver;
    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    private CheckingAccount receiverAccount;
    private Double amount;
    private LocalDateTime date;
}
