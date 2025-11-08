package com.arkenna.indienest.backend.community.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Publication Image Value Object
 */
@Embeddable
public record PublicationImage(String image) {

    /**
     * Constructor with validation
     * @param image Image
     */
    public PublicationImage {
        if(image.isBlank())
            throw new IllegalArgumentException("Image cannot be blank");
    }
}
