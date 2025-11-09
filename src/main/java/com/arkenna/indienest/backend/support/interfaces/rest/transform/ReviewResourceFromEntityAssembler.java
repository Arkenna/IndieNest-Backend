package com.arkenna.indienest.backend.support.interfaces.rest.transform;

import com.arkenna.indienest.backend.support.domain.model.aggregates.Review;
import com.arkenna.indienest.backend.support.interfaces.rest.resources.ReviewResource;

public class ReviewResourceFromEntityAssembler {

    public static ReviewResource toResourceFromEntity(Review entity){
        return new ReviewResource(
                entity.getId(),
                entity.getUserId().userId(),
                entity.getProjectId().projectId(),
                entity.getComment().comment(),
                entity.getRating().rating());
    }
}
