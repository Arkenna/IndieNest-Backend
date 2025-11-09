package com.arkenna.indienest.backend.support.domain.services;

import com.arkenna.indienest.backend.support.domain.model.aggregates.Review;
import com.arkenna.indienest.backend.support.domain.model.commands.CreateReviewCommand;

import java.util.Optional;

/**
 * Review Command Service
 */
public interface ReviewCommandService {

    /**
     * Handle Create Review Command
     * @param command The {@link CreateReviewCommand} command
     * @return a {@link Review} instance
     */
    Optional<Review> handle(CreateReviewCommand command);
}
