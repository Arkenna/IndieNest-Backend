package com.arkenna.indienest.backend.project.interfaces.rest.transform;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Game;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.GameResource;

/**
 * Assembler to convert a Game entity to an GameResource
 */
public class GameResourceFromEntityAssembler {

    /**
     * Converts a Game entity to an GameResource
     *
     * @param entity the {@link Game} entity to convert
     * @return The {@link GameResource} resource
     */
    public static GameResource toResourceFromEntity(Game entity) {
        return new GameResource(
                entity.getId(),
                entity.getAccountId().accountId(),
                entity.getName().name(),
                entity.getDescription().description(),
                entity.getRating().rating(),
                entity.getImage().image(),
                entity.getPrice().amount(),
                entity.getCategory().name());
    }
}
