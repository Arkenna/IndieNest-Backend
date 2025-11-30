package com.arkenna.indienest.backend.community.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Publication Comment Value Object
 */
@Embeddable
public record PublicationComment(String comment) {

    /**
     * Constructor with validation
     * @param comment Comment
     */
    public PublicationComment {
        if(comment.isBlank())
            throw new IllegalArgumentException("Comment cannot be blank");
    }
}
