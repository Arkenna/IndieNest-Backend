package com.arkenna.indienest.backend.community.interfaces.rest.transform;

import com.arkenna.indienest.backend.community.domain.model.aggregates.Publication;
import com.arkenna.indienest.backend.community.interfaces.rest.resources.PublicationResource;

/**
 * Assembler to convert a Publication entity to an PublicationResource
 */
public class PublicationResourceFromEntityAssembler {

    /**
     * Converts a Publication entity to an PublicationResource
     *
     * @param entity the {@link Publication} entity to convert
     * @return The {@link PublicationResource} resource
     */
    public static PublicationResource toResourceFromEntity(Publication entity) {
        return new PublicationResource(
                entity.getId(),
                entity.getUserId().userId(),
                entity.getTitle().title(),
                entity.getComment().comment(),
                entity.getImage().image());
    }
}
