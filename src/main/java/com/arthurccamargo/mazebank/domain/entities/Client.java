package com.arthurccamargo.mazebank.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String password;
    private String cpf;
    private String email;
    private String phone;
}
