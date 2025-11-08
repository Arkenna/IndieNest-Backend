package com.arkenna.indienest.backend.community.domain.model.valueobjects;

/**
 * Publication Comment Value Object
 */
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
