package com.arkenna.indienest.backend.support.interfaces.rest.transform;

import com.arkenna.indienest.backend.support.domain.model.commands.CreateReviewCommand;
import com.arkenna.indienest.backend.support.interfaces.rest.resources.CreateReviewResource;

public class CreateReviewCommandFromResourceAssembler {

    public static CreateReviewCommand toCommandFromResource(CreateReviewResource resource) {
        return new CreateReviewCommand(resource.userId(), resource.projectId(), resource.comment(), resource.rating());
    }
}
