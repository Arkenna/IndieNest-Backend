package com.arkenna.indienest.backend.iam.domain.services;

import com.arkenna.indienest.backend.iam.domain.model.aggregates.Account;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetAccountByIdQuery;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetAllAccountsQuery;

import java.util.List;
import java.util.Optional;

public interface AccountQueryService {
    Optional<Account> handle(GetAccountByIdQuery query);
    List<Account> handle(GetAllAccountsQuery query);
}