package com.arkenna.indienest.backend.support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Review Comment Value Object
 * @param comment
 */
@Embeddable
public record ReviewComment(String comment) {

    /**
     * Constructor with validation
     * @param comment The Review Comment
     */
    public ReviewComment {
        if (comment == null || comment.isBlank()) {
            throw new IllegalArgumentException("Comment cannot be null or blank");
        }
    }
}
