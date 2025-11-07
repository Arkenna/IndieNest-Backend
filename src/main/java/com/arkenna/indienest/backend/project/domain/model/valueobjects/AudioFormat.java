package com.arkenna.indienest.backend.project.domain.model.valueobjects;

/**
 *AudioFormat Value object
 */
public record AudioFormat(String format) {

    /**
     * Constructor with validation
     * @param format Audio Format
     */
    public AudioFormat {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("format cannot be null or blank");
        }
    }
}
