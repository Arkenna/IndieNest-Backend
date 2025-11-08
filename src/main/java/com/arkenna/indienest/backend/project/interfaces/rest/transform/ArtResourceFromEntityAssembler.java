package com.arkenna.indienest.backend.project.interfaces.rest.transform;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Art;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.ArtResource;

/**
 * Assembler to convert an Art entity to an ArtResource
 */
public class ArtResourceFromEntityAssembler {

    /**
     * Converts an Art entity to an ArtResource
     *
     * @param entity the {@link Art} entity to convert
     * @return The {@link ArtResource} resource
     */
    public static ArtResource toResourceFromEntity(Art entity) {
        return new ArtResource(
                entity.getId(),
                entity.getAccountId().accountId(),
                entity.getName().name(),
                entity.getDescription().description(),
                entity.getRating().rating(),
                entity.getImage().image(),
                entity.getCategory().name());
    }
}
