package com.arkenna.indienest.backend.community.domain.model.valueobjects;

/**
 * User Id value Object
 */
public record UserId(Integer userId) {

    /**
     * Constructor with validation
     * @param userId UserId
     */
    public UserId {
        if(userId == null || userId < 0)
            throw new IllegalArgumentException("Invalid user id");
    }
}
