package com.arkenna.indienest.backend.support.application.internal.queryservices;

import com.arkenna.indienest.backend.support.domain.model.aggregates.Review;
import com.arkenna.indienest.backend.support.domain.model.queries.GetAllReviewsQuery;
import com.arkenna.indienest.backend.support.domain.model.queries.GetReviewByIdQuery;
import com.arkenna.indienest.backend.support.domain.services.ReviewQueryService;
import com.arkenna.indienest.backend.support.infrastructure.persistence.jpa.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public ReviewQueryServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    public List<Review> handle(GetAllReviewsQuery query){
        return this.reviewRepository.findAll();
    }

    public Optional<Review> handle(GetReviewByIdQuery query){
        return this.reviewRepository.findById(query.id());
    }

}
