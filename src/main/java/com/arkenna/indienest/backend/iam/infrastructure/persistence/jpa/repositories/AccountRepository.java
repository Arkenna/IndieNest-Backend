package com.arkenna.indienest.backend.iam.infrastructure.persistence.jpa.repositories;

import com.arkenna.indienest.backend.iam.domain.model.aggregates.Account;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.Email;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmail(Email email);
    boolean existsByEmail(Email email);
    Optional<Account> findByUserId(UserId userId);
    boolean existsByUserId(UserId userId);
}