package com.arkenna.indienest.backend.community.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * User Id value Object
 */
@Embeddable
public record UserId(Integer userId) {

    /**
     * Constructor with validation
     * @param userId UserId
     */
    public UserId {
        if(userId == null || userId < 1)
            throw new IllegalArgumentException("Invalid user id");
    }
}
