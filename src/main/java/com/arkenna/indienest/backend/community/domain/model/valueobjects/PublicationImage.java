package com.arkenna.indienest.backend.community.domain.model.valueobjects;

/**
 * Publication Image Value Object
 */
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
