package com.arkenna.indienest.backend.profile.interfaces.rest.transform;

import com.arkenna.indienest.backend.profile.domain.model.commands.AddGameToPortfolioCommand;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.AddGameToPortfolioResource;

public class AddGameToPortfolioCommandFromResourceAssembler {

    public static AddGameToPortfolioCommand toCommandFromResource(AddGameToPortfolioResource resource) {
        return new AddGameToPortfolioCommand(resource.portfolioId(),resource.gameId());
    }
}
