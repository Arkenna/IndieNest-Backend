package com.arkenna.indienest.backend.iam.interfaces.rest.transform;

import com.arkenna.indienest.backend.iam.domain.model.commands.UpdateUserCommand;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.UpdateUserResource;

public class UpdateUserCommandFromResourceAssembler {
    public static UpdateUserCommand toCommandFromResource(Integer id, UpdateUserResource resource) {
        return new UpdateUserCommand(
                id,
                resource.name(),
                resource.phoneNumber()
        );
    }
}