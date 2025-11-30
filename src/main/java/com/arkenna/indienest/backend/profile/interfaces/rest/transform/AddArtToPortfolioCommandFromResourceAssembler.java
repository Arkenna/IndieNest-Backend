package com.arkenna.indienest.backend.profile.interfaces.rest.transform;

import com.arkenna.indienest.backend.profile.domain.model.commands.AddArtToPortfolioCommand;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.AddArtToPortfolioResource;

public class AddArtToPortfolioCommandFromResourceAssembler {

    public static AddArtToPortfolioCommand toCommandFromResource(AddArtToPortfolioResource resource){
        return new AddArtToPortfolioCommand(resource.portfolioId(), resource.artId());
    }
}
