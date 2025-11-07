package com.arkenna.indienest.backend.project.domain.model.valueobjects;

/**
 * Rating Value Object
 */
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
