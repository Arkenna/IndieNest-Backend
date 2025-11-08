package com.arkenna.indienest.backend.community.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Publication Title Value Object
 */
@Embeddable
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
