package com.arkenna.indienest.backend.community.interfaces.rest.transform;

import com.arkenna.indienest.backend.community.domain.model.commands.CreateAnswerCommand;
import com.arkenna.indienest.backend.community.interfaces.rest.resources.CreateAnswerResource;

/**
 * Assembler to convert a CreateAnswerResource to a CreateAnswerCommand
 */
public class CreateAnswerCommandFromResourceAssembler {

    /**
     * Converts a CreateAnswerResource to a CreateAnswerCommand
     *
     * @param resource The {@link CreateAnswerResource} resource to convert
     * @return The {@link CreateAnswerCommand} command
     */
    public static CreateAnswerCommand toCommandFromResource(CreateAnswerResource resource) {
        return new CreateAnswerCommand(resource.userId(), resource.publicationId(), resource.comment());
    }
}
