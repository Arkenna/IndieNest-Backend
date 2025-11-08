package com.arkenna.indienest.backend.project.interfaces.rest.transform;

import com.arkenna.indienest.backend.project.domain.model.commands.CreateAudioCommand;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.CreateAudioResource;

/**
 * Assembler to convert a CreateAudioResource to a CreateAudioCommand
 */
public class CreateAudioCommandFromResourceAssembler {

    /**
     * Converts a CreateAudioResource to a CreateAudioCommand
     * @param resource The {@link CreateAudioResource} resource to convert
     * @return The {@link CreateAudioCommand} command
     */
    public static CreateAudioCommand toCommandFromResource(CreateAudioResource resource) {
        return new CreateAudioCommand(resource.accountId(),
                resource.name(),
                resource.description(),
                resource.rating(),
                resource.image(),
                resource.category(),
                resource.audioUrl(),
                resource.format());
    }
}
