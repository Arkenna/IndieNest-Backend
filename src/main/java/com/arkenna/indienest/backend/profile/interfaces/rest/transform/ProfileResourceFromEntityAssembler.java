package com.arkenna.indienest.backend.profile.interfaces.rest.transform;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Profile;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {

    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(
                entity.getId(),
                entity.getDescription().description(),
                entity.getImage().image(),
                entity.getAccountId().accountId(),
                entity.getPortfolioId().portfolioId()
        );
    }
}
