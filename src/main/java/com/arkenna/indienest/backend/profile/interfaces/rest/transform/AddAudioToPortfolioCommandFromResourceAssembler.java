package com.arkenna.indienest.backend.profile.interfaces.rest.transform;

import com.arkenna.indienest.backend.profile.domain.model.commands.AddAudioToPortfolioCommand;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.AddAudioToPortfolioResource;

public class AddAudioToPortfolioCommandFromResourceAssembler {

    public static AddAudioToPortfolioCommand toCommandFromResource(AddAudioToPortfolioResource resource){
        return new AddAudioToPortfolioCommand(resource.portfolioId(), resource.audioId());
    }
}
