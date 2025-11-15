package com.arkenna.indienest.backend.iam.application.acl;

import com.arkenna.indienest.backend.iam.domain.model.aggregates.Account;
import com.arkenna.indienest.backend.iam.domain.model.aggregates.User;
import com.arkenna.indienest.backend.iam.domain.model.commands.CreateAccountCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.CreateUserCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.UpdateUserCommand;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetAllAccountsQuery;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetAllUsersQuery;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetAccountByIdQuery;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetUserByIdQuery;
import com.arkenna.indienest.backend.iam.domain.services.AccountCommandService;
import com.arkenna.indienest.backend.iam.domain.services.AccountQueryService;
import com.arkenna.indienest.backend.iam.domain.services.UserCommandService;
import com.arkenna.indienest.backend.iam.domain.services.UserQueryService;
import com.arkenna.indienest.backend.iam.interfaces.acl.IamContextFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IamContextFacadeImpl implements IamContextFacade {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;
    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    public IamContextFacadeImpl(UserCommandService userCommandService, UserQueryService userQueryService,
                                AccountCommandService accountCommandService, AccountQueryService accountQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
        this.accountCommandService = accountCommandService;
        this.accountQueryService = accountQueryService;
    }

    // USER
    @Override
    public Optional<Integer> createUser(CreateUserCommand command) {
        return userCommandService.handle(command);
    }
    @Override
    public Optional<Integer> updateUser(UpdateUserCommand command) {
        return userCommandService.handle(command);
    }
    @Override
    public Optional<User> fetchUserById(Integer id) {
        var query = new GetUserByIdQuery(id);
        return userQueryService.handle(query);
    }
    @Override
    public List<User> fetchAllUsers() {
        var query = new GetAllUsersQuery();
        return userQueryService.handle(query);
    }

    //ACCOUNT

    @Override
    public Optional<Integer> createAccount(CreateAccountCommand command) {
        return accountCommandService.handle(command);
    }
    @Override
    public Optional<Account> fetchAccountById(Integer id) {
        var query = new GetAccountByIdQuery(id);
        return accountQueryService.handle(query);
    }
    @Override
    public List<Account> fetchAllAccounts() {
        var query = new GetAllAccountsQuery();
        return accountQueryService.handle(query);
    }
}
