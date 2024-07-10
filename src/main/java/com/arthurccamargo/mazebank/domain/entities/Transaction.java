package com.arthurccamargo.mazebank.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Client sender;
    @ManyToOne
    private Client receiver;
    private Double amount;
    private LocalDate date;
}
