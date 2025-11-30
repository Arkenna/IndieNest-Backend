package com.arkenna.indienest.backend.support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Rating Value Object
 * @param rating
 */
@Embeddable
public record Rating(Integer rating) {

    /**
     * Constructor with validation
     * @param rating The Review Rating
     */
    public Rating {
        if(rating == null || rating < 0)
            throw new IllegalArgumentException("Rating cannot be null or negative");
    }
}
