package com.arkenna.indienest.backend.profile.interfaces.rest.transform;

import com.arkenna.indienest.backend.profile.domain.model.entities.PortfolioArt;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.PortfolioArtResource;

public class PortfolioArtResourceFromEntityAssembler {

    public static PortfolioArtResource toResourceFromEntity(PortfolioArt entity){
        return new PortfolioArtResource(entity.getId(), entity.getPortfolio().getId(), entity.getArtId());
    }
}
