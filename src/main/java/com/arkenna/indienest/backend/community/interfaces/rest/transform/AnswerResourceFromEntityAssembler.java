package com.arkenna.indienest.backend.community.interfaces.rest.transform;

import com.arkenna.indienest.backend.community.domain.model.aggregates.Answer;
import com.arkenna.indienest.backend.community.interfaces.rest.resources.AnswerResource;

/**
 * Assembler to convert an Answer entity to an AnswerResource
 */
public class AnswerResourceFromEntityAssembler {

    /**
     * Converts an Answer entity to an AnswerResource
     *
     * @param entity the {@link Answer} entity to convert
     * @return The {@link AnswerResource} resource
     */
    public static AnswerResource toResourceFromEntity(Answer entity) {
        return new AnswerResource(
                entity.getId(),
                entity.getUserId().userId(),
                entity.getPublicationId().publicationId(),
                entity.getComment().comment());
    }
}

