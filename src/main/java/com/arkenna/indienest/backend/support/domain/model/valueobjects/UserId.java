package com.arkenna.indienest.backend.support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * User ID value object
 */
@Embeddable
public record UserId(Integer userId) {

    /**
     * Constructor with validation
     * @param userId The Review User ID
     */
    public UserId {
        if(userId == null || userId < 1)
            throw new IllegalArgumentException("UserId cannot be null or less than 1");
    }

}
