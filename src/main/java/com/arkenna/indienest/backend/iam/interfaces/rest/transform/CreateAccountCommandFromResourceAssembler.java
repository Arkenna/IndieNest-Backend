package com.arkenna.indienest.backend.iam.interfaces.rest.transform;

import com.arkenna.indienest.backend.iam.domain.model.commands.CreateAccountCommand;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.CreateAccountResource;

public class CreateAccountCommandFromResourceAssembler {
    public static CreateAccountCommand toCommandFromResource(CreateAccountResource resource) {
        return new CreateAccountCommand(
                resource.userId(),
                resource.email(),
                resource.password(),
                resource.role(),
                resource.isActive()
        );
    }
}