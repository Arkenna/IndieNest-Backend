package com.arkenna.indienest.backend.support.application.acl;

import com.arkenna.indienest.backend.support.domain.model.commands.CreateReviewCommand;
import com.arkenna.indienest.backend.support.domain.services.ReviewCommandService;
import com.arkenna.indienest.backend.support.interfaces.acl.SupportContextFacade;

public class SupportContextFacadeImpl implements SupportContextFacade {

    ReviewCommandService reviewCommandService;

    public SupportContextFacadeImpl(ReviewCommandService reviewCommandService) {
        this.reviewCommandService = reviewCommandService;
    }

    @Override
    public Integer createReview(Integer userId, Integer projectId, String comment, Integer rating) {

        var createReviewCommand = new CreateReviewCommand(userId, projectId, comment, rating);
        var review = this.reviewCommandService.handle(createReviewCommand);
        return review.isEmpty() ? 0 : review.get().getId();
    }
}
