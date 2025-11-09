package com.arkenna.indienest.backend.support.domain.services;

import com.arkenna.indienest.backend.support.domain.model.aggregates.Review;
import com.arkenna.indienest.backend.support.domain.model.queries.GetAllReviewsQuery;
import com.arkenna.indienest.backend.support.domain.model.queries.GetReviewByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * Review Query Service
 */
public interface ReviewQueryService {

    /**
     * Handle Get All Reviews Query
     * @param query The {@link GetAllReviewsQuery} query
     * @return A List of {@link Review} instances
     */
    List<Review> handle(GetAllReviewsQuery query);

    /**
     * Handle Get a Review By ID Query
     * @param query The {@link GetReviewByIdQuery} query
     * @return A {@link Review} instance
     */
    Optional<Review> handle(GetReviewByIdQuery query);
}
