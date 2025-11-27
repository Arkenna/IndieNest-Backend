package com.arkenna.indienest.backend.profile.interfaces.rest.transform;

import com.arkenna.indienest.backend.profile.domain.model.commands.CreateProfileCommand;
import com.arkenna.indienest.backend.profile.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {

    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(
                resource.description(),
                resource.image(),
                resource.accountId(),
                resource.portfolioId()
        );
    }
}
