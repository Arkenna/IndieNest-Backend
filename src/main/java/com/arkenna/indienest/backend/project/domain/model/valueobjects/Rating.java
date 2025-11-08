package com.arkenna.indienest.backend.project.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Rating Value Object
 */
@Embeddable
public record Rating(Integer rating) {

    /**
     * Constructor with validation
     * @param rating Rating
     */
    public Rating {
        if(rating < 0)
            throw new IllegalArgumentException("Rating cannot be less than 0");
    }
}
