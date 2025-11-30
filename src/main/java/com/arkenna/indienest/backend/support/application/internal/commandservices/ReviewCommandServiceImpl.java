package com.arkenna.indienest.backend.support.application.internal.commandservices;

import com.arkenna.indienest.backend.support.domain.model.aggregates.Review;
import com.arkenna.indienest.backend.support.domain.model.commands.CreateReviewCommand;
import com.arkenna.indienest.backend.support.domain.model.valueobjects.ReviewComment;
import com.arkenna.indienest.backend.support.domain.model.valueobjects.UserId;
import com.arkenna.indienest.backend.support.domain.services.ReviewCommandService;
import com.arkenna.indienest.backend.support.infrastructure.persistence.jpa.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {

    ReviewRepository reviewRepository;

    public ReviewCommandServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Optional<Review> handle(CreateReviewCommand command){

        var userId= new UserId(command.userId());
        var comment = new ReviewComment(command.comment());
        if(reviewRepository.existsByUserIdAndComment(userId, comment))
            throw new IllegalStateException("Review already exists with same userId and comment");

        var review = new Review(command);
        reviewRepository.save(review);
        return Optional.of(review);
    }

}
