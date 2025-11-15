package com.arkenna.indienest.backend.iam.interfaces.acl;

import com.arkenna.indienest.backend.iam.domain.model.aggregates.Account;
import com.arkenna.indienest.backend.iam.domain.model.aggregates.User;
import com.arkenna.indienest.backend.iam.domain.model.commands.CreateAccountCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.CreateUserCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.UpdateUserCommand;

import java.util.List;
import java.util.Optional;

public interface IamContextFacade {

    Optional<Integer> createUser(CreateUserCommand command);
    Optional<Integer> updateUser(UpdateUserCommand command);
    Optional<User> fetchUserById(Integer id);
    List<User> fetchAllUsers();

    Optional<Integer> createAccount(CreateAccountCommand command);
    Optional<Account> fetchAccountById(Integer id);
    List<Account> fetchAllAccounts();
}
