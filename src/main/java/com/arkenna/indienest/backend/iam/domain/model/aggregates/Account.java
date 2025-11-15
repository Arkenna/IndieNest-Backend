package com.arkenna.indienest.backend.iam.domain.model.aggregates;

import com.arkenna.indienest.backend.iam.domain.model.commands.CreateAccountCommand;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.AccountType;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.Email;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.Password;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.UserId;
import com.arkenna.indienest.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "accounts")
@Getter
public class Account extends AuditableAbstractAggregateRoot<Account> {

    @Embedded
    @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false, unique = true))
    private UserId userId;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @Column(nullable = false)
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private AccountType role;

    public Account() {
    }

    public Account(CreateAccountCommand command) {
        this.userId = new UserId(command.userId());
        this.email = new Email(command.email());
        this.password = new Password(command.password());
        this.isActive = command.isActive();
        this.role = AccountType.valueOf(command.role().toUpperCase());
    }

    public void updateEmail(String email) {
        this.email = new Email(email);
    }

    public void updatePassword(String password) {
        this.password = new Password(password);
    }

    public void updateIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void updateRole(String role) {
        this.role = AccountType.valueOf(role.toUpperCase());
    }
}