package com.arkenna.indienest.backend.iam.interfaces.rest.transform;

import com.arkenna.indienest.backend.iam.domain.model.commands.SignUpCommand;
import com.arkenna.indienest.backend.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(
                resource.name(),
                resource.phoneNumber(),
                resource.email(),
                resource.password(),
                resource.role()
        );
    }
}