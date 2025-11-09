package com.arkenna.indienest.backend.community.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Answer Comment Value Object
 */
@Embeddable
public record AnswerComment(String comment) {

    /**
     * Constructor with validation
     * @param comment Comment
     */
    public AnswerComment {
        if(comment == null || comment.isBlank())
            throw new IllegalArgumentException("Comment cannot be null or blank");
    }
}
