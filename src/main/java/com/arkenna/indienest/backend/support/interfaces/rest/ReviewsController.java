package com.arkenna.indienest.backend.support.interfaces.rest;


import com.arkenna.indienest.backend.support.domain.model.queries.GetAllReviewsQuery;
import com.arkenna.indienest.backend.support.domain.model.queries.GetReviewByIdQuery;
import com.arkenna.indienest.backend.support.domain.services.ReviewCommandService;
import com.arkenna.indienest.backend.support.domain.services.ReviewQueryService;
import com.arkenna.indienest.backend.support.interfaces.rest.resources.CreateReviewResource;
import com.arkenna.indienest.backend.support.interfaces.rest.resources.ReviewResource;
import com.arkenna.indienest.backend.support.interfaces.rest.transform.CreateReviewCommandFromResourceAssembler;
import com.arkenna.indienest.backend.support.interfaces.rest.transform.ReviewResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Reviews", description = "Available Review Endpoints")
public class ReviewsController {

    private final ReviewCommandService  reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    /**
     * Constructor
     *
     * @param reviewCommandService The {@link ReviewCommandService} instance
     * @param reviewQueryService The {@link ReviewQueryService} instance
     */
    public ReviewsController(ReviewCommandService reviewCommandService, ReviewQueryService reviewQueryService) {
        this.reviewCommandService = reviewCommandService;
        this.reviewQueryService = reviewQueryService;
    }

    /**
     * Create a new review
     * @param resource The {@link CreateReviewResource} instance
     * @return A {@link ReviewResource} resource for the created review, or a bad request response if the review could not be created.
     */
    @PostMapping
    @Operation(summary = "Create a new Review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Review created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<ReviewResource> createReview(@RequestBody CreateReviewResource resource){

        var createReviewCommand = CreateReviewCommandFromResourceAssembler.toCommandFromResource(resource);
        var review = reviewCommandService.handle(createReviewCommand);
        if(review.isEmpty()) return ResponseEntity.badRequest().build();
        var createdReview = review.get();
        var reviewResource = ReviewResourceFromEntityAssembler.toResourceFromEntity(createdReview);
        return new  ResponseEntity<>(reviewResource, HttpStatus.CREATED);
    }

    /**
     * Get a review by ID
     * @param reviewId The review ID
     * @return A {@link ReviewResource} resource for the review, or a not found response if the review could not be found.
     */
    @GetMapping("/{reviewId}")
    @Operation(summary = "Get a review by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review found"),
            @ApiResponse(responseCode = "404", description = "Review not found")})
    public ResponseEntity<ReviewResource> getReviewById(@PathVariable Integer reviewId) {
        var getReviewByIdQuery = new GetReviewByIdQuery(reviewId);
        var review = reviewQueryService.handle(getReviewByIdQuery);
        if (review.isEmpty()) return ResponseEntity.notFound().build();
        var reviewEntity = review.get();
        var reviewResource = ReviewResourceFromEntityAssembler.toResourceFromEntity(reviewEntity);
        return ResponseEntity.ok(reviewResource);
    }

    /**
     * Get all reviews
     * @return A list of {@link ReviewResource} resources for all reviews, or a not found response if no reviews are found.
     */
    @GetMapping
    @Operation(summary = "Get all reviews")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reviews found"),
            @ApiResponse(responseCode = "404", description = "Reviews not found")})
    public ResponseEntity<List<ReviewResource>> getAllReviews() {
        var reviews = reviewQueryService.handle(new GetAllReviewsQuery());
        if (reviews.isEmpty()) return ResponseEntity.notFound().build();
        var reviewResources = reviews.stream()
                .map(ReviewResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(reviewResources);
    }

}
