package com.arthurccamargo.mazebank.repositories;

import com.arthurccamargo.mazebank.domain.entities.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
}
