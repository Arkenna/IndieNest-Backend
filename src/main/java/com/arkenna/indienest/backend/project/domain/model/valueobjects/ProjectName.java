package com.arkenna.indienest.backend.project.domain.model.valueobjects;

/**
 *ProjectName Value Object
 */
public record ProjectName(String name) {

    /**
     * Constructor with validation
     * @param name Project Name
     */
    public ProjectName {
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
    }
}
