package com.arthurccamargo.mazebank.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long sender;
    private Long receiver;
    private Double amount;
}
