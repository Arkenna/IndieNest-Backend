package com.arkenna.indienest.backend.profile.interfaces.rest.transform;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Portfolio;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.PortfolioResource;

public class PortfolioResourceFromEntityAssembler {

    public static PortfolioResource toResourceFromEntity(Portfolio entity){
        return new PortfolioResource(
                entity.getId(),
                entity.getGames().stream().map(PortfolioGameResourceFromEntityAssembler::toResourceFromEntity).toList(),
                entity.getAudios().stream().map(PortfolioAudioResourceFromEntityAssembler::toResourceFromEntity).toList(),
                entity.getArts().stream().map(PortfolioArtResourceFromEntityAssembler::toResourceFromEntity).toList()
        );
    }
}
