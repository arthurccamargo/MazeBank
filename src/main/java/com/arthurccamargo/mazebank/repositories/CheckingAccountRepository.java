package com.arthurccamargo.mazebank.repositories;

import com.arthurccamargo.mazebank.domain.entities.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, UUID> {
}
