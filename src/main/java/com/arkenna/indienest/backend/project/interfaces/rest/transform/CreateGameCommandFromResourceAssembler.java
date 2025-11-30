package com.arkenna.indienest.backend.project.interfaces.rest.transform;

import com.arkenna.indienest.backend.project.domain.model.commands.CreateGameCommand;
import com.arkenna.indienest.backend.project.interfaces.rest.resources.CreateGameResource;

/**
 * Assembler to convert a CreateGameResource to a CreateGameCommand
 */
public class CreateGameCommandFromResourceAssembler {

    /**
     * Converts a CreateGameResource to a CreateGameCommand
     *
     * @param resource The {@link CreateGameResource} resource to convert
     * @return The {@link CreateGameCommand} command
     */
    public static CreateGameCommand toCommandFromResource(CreateGameResource resource) {
        return new CreateGameCommand(resource.accountId(),
                resource.name(),
                resource.description(),
                resource.rating(),
                resource.image(),
                resource.category(),
                resource.price());
    }
}
