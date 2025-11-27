package com.arkenna.indienest.backend.profile.interfaces.rest.transform;

import com.arkenna.indienest.backend.profile.domain.model.entities.PortfolioGame;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.PortfolioGameResource;

public class PortfolioGameResourceFromEntityAssembler {

    public static PortfolioGameResource toResourceFromEntity(PortfolioGame entity){
        return new PortfolioGameResource(entity.getId(), entity.getPortfolio().getId(), entity.getGameId());
    }
}
