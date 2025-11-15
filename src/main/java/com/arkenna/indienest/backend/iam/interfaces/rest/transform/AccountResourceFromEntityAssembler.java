package com.arkenna.indienest.backend.iam.interfaces.rest.transform;

import com.arkenna.indienest.backend.iam.domain.model.aggregates.Account;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.AccountResource;

public class AccountResourceFromEntityAssembler {
    public static AccountResource toResourceFromEntity(Account entity) {
        return new AccountResource(
                entity.getId(),
                entity.getUserId().userId(),
                entity.getEmail().email(),
                entity.getRole().name(),
                entity.isActive()
        );
    }
}