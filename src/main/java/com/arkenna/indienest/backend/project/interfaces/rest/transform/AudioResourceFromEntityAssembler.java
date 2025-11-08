package com.arkenna.indienest.backend.project.interfaces.rest.transform;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Audio;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.AudioResource;

/**
 * Assembler to convert an Audio entity to an AudioResource
 */
public class AudioResourceFromEntityAssembler {

    /**
     * Converts an Audio entity to an AudioResource
     *
     * @param entity the {@link Audio} entity to convert
     * @return The {@link AudioResource} resource
     */
    public static AudioResource toResourceFromEntity(Audio entity) {
        return new AudioResource(
                entity.getId(),
                entity.getAccountId().accountId(),
                entity.getName().name(),
                entity.getDescription().description(),
                entity.getRating().rating(),
                entity.getImage().image(),
                entity.getAudioUrl().url(),
                entity.getAudioFormat().format(),
                entity.getCategory().name());
    }
}
