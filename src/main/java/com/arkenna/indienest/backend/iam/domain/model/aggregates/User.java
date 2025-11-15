package com.arkenna.indienest.backend.iam.domain.model.aggregates;

import com.arkenna.indienest.backend.iam.domain.model.commands.CreateUserCommand;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.PhoneNumber;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.UserName;
import com.arkenna.indienest.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Entity
@Table(name = "users")
@Getter
public class User extends AuditableAbstractAggregateRoot<User> {

    @Embedded
    private UserName name;

    @Embedded
    private PhoneNumber phoneNumber;

    public User() {
    }

    public User(CreateUserCommand command) {
        this.name = new UserName(command.name());
        this.phoneNumber = new PhoneNumber(command.phoneNumber());
    }

    public void updateName(String name) {
        if (Strings.isNotBlank(name)) {
            this.name = new UserName(name);
        }
    }

    public void updatePhoneNumber(String phone) {
        this.phoneNumber = new PhoneNumber(phone);
    }
}