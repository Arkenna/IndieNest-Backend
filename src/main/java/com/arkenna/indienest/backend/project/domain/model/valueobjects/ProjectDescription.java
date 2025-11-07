package com.arkenna.indienest.backend.project.domain.model.valueobjects;

/**
 *ProjectDescription Value Object
 */
public record ProjectDescription(String description) {

    /**
     * Constructor with validation
     * @param description Project Description
     */
    public ProjectDescription {
        if(description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
    }
}
