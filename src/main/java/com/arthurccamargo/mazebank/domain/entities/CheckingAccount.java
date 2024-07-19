package com.arthurccamargo.mazebank.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "checking_account")
public class CheckingAccount {
    @Id
    @GeneratedValue
    private Long id;
    private String accountNumber;
    private Double balance;
    private Integer transaction_limit;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;
}
