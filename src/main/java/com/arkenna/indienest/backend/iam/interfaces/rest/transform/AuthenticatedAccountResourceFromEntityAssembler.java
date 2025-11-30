package com.arkenna.indienest.backend.iam.interfaces.rest.transform;

import com.arkenna.indienest.backend.iam.domain.model.aggregates.Account;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.AuthenticatedAccountResource;

public class AuthenticatedAccountResourceFromEntityAssembler {
    public static AuthenticatedAccountResource toResourceFromEntity(Account entity, String token) {
        return new AuthenticatedAccountResource(
                entity.getId(),
                entity.getUserId().userId(),
                entity.getEmail().email(),
                entity.getRole().name(),
                token
        );
    }
}