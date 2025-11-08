package com.arkenna.indienest.backend.community.domain.model.valueobjects;

/**
 * Publication Title Value Object
 */
public record PublicationTitle(String title) {

    /**
     * Constructor with validation
     * @param title Title
     */
    public PublicationTitle {
        if(title == null || title.isBlank())
            throw new IllegalArgumentException("Title cannot be null or blank");
    }
}
