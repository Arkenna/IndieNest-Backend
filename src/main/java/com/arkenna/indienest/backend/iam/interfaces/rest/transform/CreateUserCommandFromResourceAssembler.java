package com.arkenna.indienest.backend.iam.interfaces.rest.transform;

import com.arkenna.indienest.backend.iam.domain.model.commands.CreateUserCommand;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(
                resource.name(),
                resource.phoneNumber()
        );
    }
}