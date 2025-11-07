package com.arkenna.indienest.backend.project.domain.model.valueobjects;

/**
 * ProjectImage Value Object
 */
public record ProjectImage(String image) {

    /**
     * Constructor with validation
     * @param image Project Image
     */
    public ProjectImage {
        if (image == null || image.isBlank())
            throw new IllegalArgumentException("Project image cannot be null or blank");
    }
}
