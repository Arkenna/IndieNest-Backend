package com.arkenna.indienest.backend.iam.interfaces.rest;

import com.arkenna.indienest.backend.iam.domain.model.queries.GetAccountByIdQuery;
import com.arkenna.indienest.backend.iam.domain.model.queries.GetAllAccountsQuery;
import com.arkenna.indienest.backend.iam.domain.services.AccountQueryService;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.AccountResource;
import com.arkenna.indienest.backend.iam.interfaces.rest.transform.AccountResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Accounts", description = "Available Account Endpoints")
public class AccountsController {

    private final AccountQueryService accountQueryService;

    public AccountsController(AccountQueryService accountQueryService) {
        this.accountQueryService = accountQueryService;
    }

    @GetMapping
    public ResponseEntity<List<AccountResource>> getAllAccounts() {
        var query = new GetAllAccountsQuery();
        var accounts = accountQueryService.handle(query);
        var accountResources = accounts.stream()
                .map(AccountResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(accountResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResource> getAccountById(@PathVariable Integer id) {
        var query = new GetAccountByIdQuery(id);
        var account = accountQueryService.handle(query);
        if (account.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var accountResource = AccountResourceFromEntityAssembler.toResourceFromEntity(account.get());
        return ResponseEntity.ok(accountResource);
    }
}