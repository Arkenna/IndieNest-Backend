package com.arkenna.indienest.backend.profile.interfaces.rest.transform;

import com.arkenna.indienest.backend.profile.domain.model.entities.PortfolioAudio;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.PortfolioAudioResource;

public class PortfolioAudioResourceFromEntityAssembler {

    public static PortfolioAudioResource toResourceFromEntity(PortfolioAudio entity){
        return new PortfolioAudioResource(entity.getId(), entity.getPortfolio().getId(), entity.getAudioId());
    }
}
