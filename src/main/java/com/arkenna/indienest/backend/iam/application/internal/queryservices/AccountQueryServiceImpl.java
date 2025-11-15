package com.arkenna.indienest.backend.iam.application.internal.queryservices;

import com.arkenna.indienest.backend.iam.domain.model.aggregates.Account;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetAccountByIdQuery;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetAllAccountsQuery;
import com.arkenna.indienest.backend.iam.domain.services.AccountQueryService;
import com.arkenna.indienest.backend.iam.infrastructure.persistence.jpa.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository accountRepository;

    public AccountQueryServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> handle(GetAccountByIdQuery query) {
        return accountRepository.findById(query.id());
    }

    @Override
    public List<Account> handle(GetAllAccountsQuery query) {
        return accountRepository.findAll();
    }
}