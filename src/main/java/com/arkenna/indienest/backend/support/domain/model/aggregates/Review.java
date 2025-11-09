package com.arkenna.indienest.backend.support.domain.model.aggregates;

import com.arkenna.indienest.backend.community.domain.model.valueobjects.UserId;
import com.arkenna.indienest.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.arkenna.indienest.backend.support.domain.model.commands.CreateReviewCommand;
import com.arkenna.indienest.backend.support.domain.model.valueobjects.ProjectId;
import com.arkenna.indienest.backend.support.domain.model.valueobjects.Rating;
import com.arkenna.indienest.backend.support.domain.model.valueobjects.ReviewComment;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

/**
 * Review Aggregate Root
 */
@Entity
@Getter
public class Review extends AuditableAbstractAggregateRoot<Review> {

    @Embedded
    private UserId userId;

    @Embedded
    private ProjectId projectId;

    @Embedded
    private ReviewComment comment;

    @Embedded
    private Rating rating;

    /**
     * Default Constructor
     */
    public Review() {}

    public Review(CreateReviewCommand command){
        this.userId = new UserId(command.userId());
        this.projectId = new ProjectId(command.projectId());
        this.comment = new ReviewComment(command.comment());
        this.rating = new Rating(command.rating());
    }

}
