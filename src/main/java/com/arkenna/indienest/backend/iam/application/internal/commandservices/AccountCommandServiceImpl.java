package com.arkenna.indienest.backend.iam.application.internal.commandservices;

import com.arkenna.indienest.backend.iam.application.internal.outboundservices.hashing.HashingService;
import com.arkenna.indienest.backend.iam.application.internal.outboundservices.tokens.TokenService;
import com.arkenna.indienest.backend.iam.domain.model.aggregates.Account;
import com.arkenna.indienest.backend.iam.domain.model.aggregates.User;
import com.arkenna.indienest.backend.iam.domain.model.commands.CreateAccountCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.CreateUserCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.SignInCommand;
import com.arkenna.indienest.backend.iam.domain.model.commands.SignUpCommand;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.Email;
import com.arkenna.indienest.backend.iam.domain.model.valueobjects.UserId;
import com.arkenna.indienest.backend.iam.domain.services.AccountCommandService;
import com.arkenna.indienest.backend.iam.infrastructure.persistence.jpa.repositories.AccountRepository;
import com.arkenna.indienest.backend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    public AccountCommandServiceImpl(AccountRepository accountRepository, UserRepository userRepository, HashingService hashingService, TokenService tokenService) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
    }

    @Override
    public Optional<Integer> handle(CreateAccountCommand command) {

        if (accountRepository.existsByEmail(new Email(command.email()))) {
            throw new IllegalArgumentException("Account with email " + command.email() + " already exists");
        }
        var userId = new UserId(command.userId());
        if (accountRepository.existsByUserId(userId)) {
            throw new IllegalArgumentException("Account with userId " + command.userId() + " already exists");
        }

        if (!userRepository.existsById(command.userId())) {
            throw new IllegalArgumentException("User with id " + command.userId() + " does not exist");
        }

        var account = new Account(command);
        var createdAccount = accountRepository.save(account);
        return Optional.of(createdAccount.getId());
    }

    @Override
    public Optional<Integer> handle(SignUpCommand command) {

        if (accountRepository.existsByEmail(new Email(command.email()))) {
            throw new IllegalArgumentException("Account with email " + command.email() + " already exists");
        }

        var createUserCommand = new CreateUserCommand(command.name(), command.phoneNumber());
        var user = new User(createUserCommand);
        var createdUser = userRepository.save(user);
        var newUserId = createdUser.getId();

        var hashedPassword = hashingService.encode(command.password());

        var createAccountCommand = new CreateAccountCommand(
                newUserId,
                command.email(),
                hashedPassword,
                command.role(),
                true
        );

        var account = new Account(createAccountCommand);
        var createdAccount = accountRepository.save(account);
        return Optional.of(createdAccount.getId());
    }

    @Override
    public Optional<String> handle(SignInCommand command) {
        var account = accountRepository.findByEmail(new Email(command.email()));

        if (account.isEmpty()) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        if (!hashingService.matches(command.password(), account.get().getPassword().password())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        var token = tokenService.generateToken(account.get().getEmail().email());

        return Optional.of(token);
    }
}