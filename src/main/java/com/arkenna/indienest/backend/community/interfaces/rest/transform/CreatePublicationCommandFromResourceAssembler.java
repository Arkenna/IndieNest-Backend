package com.arkenna.indienest.backend.community.interfaces.rest.transform;

import com.arkenna.indienest.backend.community.domain.model.commands.CreatePublicationCommand;
import com.arkenna.indienest.backend.community.interfaces.rest.resources.CreatePublicationResource;

/**
 * Assembler to convert a CreatePublicationResource to a CreatePublicationCommand
 */
public class CreatePublicationCommandFromResourceAssembler {

    /**
     * Converts a CreatePublicationResource to a CreatePublicationCommand
     *
     * @param resource The {@link CreatePublicationResource} resource to convert
     * @return The {@link CreatePublicationCommand} command
     */
    public static CreatePublicationCommand toCommandFromResource(CreatePublicationResource resource) {
        return new CreatePublicationCommand(resource.userId(), resource.title(), resource.comment(), resource.image());
    }
}
