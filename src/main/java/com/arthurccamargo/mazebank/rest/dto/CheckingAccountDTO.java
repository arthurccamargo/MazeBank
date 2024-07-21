package com.arthurccamargo.mazebank.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckingAccountDTO {
    private Long client;
    private String accountNumber;
    private Double balance;
    private Integer transaction_limit;
}
