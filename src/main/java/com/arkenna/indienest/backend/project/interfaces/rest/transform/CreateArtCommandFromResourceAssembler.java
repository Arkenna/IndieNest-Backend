package com.arkenna.indienest.backend.project.interfaces.rest.transform;

import com.arkenna.indienest.backend.project.domain.model.commands.CreateArtCommand;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.CreateArtResource;

/**
 * Assembler to convert a CreateArtResource to a CreateArtCommand
 */
public class CreateArtCommandFromResourceAssembler {

    /**
     * Converts a CreateArtResource to a CreateArtCommand
     *
     * @param resource The {@link CreateArtResource} resource to convert
     * @return The {@link CreateArtCommand} command
     */
    public static CreateArtCommand toCommandFromResource(CreateArtResource resource) {
        return new CreateArtCommand(resource.accountId(),
                resource.name(),
                resource.description(),
                resource.rating(),
                resource.image(),
                resource.category());
    }
}
