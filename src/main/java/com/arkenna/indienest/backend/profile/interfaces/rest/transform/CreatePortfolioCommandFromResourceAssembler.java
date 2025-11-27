package com.arkenna.indienest.backend.profile.interfaces.rest.transform;

import com.arkenna.indienest.backend.profile.domain.model.commands.CreatePortfolioCommand;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.CreatePortfolioResource;

public class CreatePortfolioCommandFromResourceAssembler {

    public static CreatePortfolioCommand toCommandFromResource(CreatePortfolioResource resource) {
        return new CreatePortfolioCommand();
    }
}
