package com.arkenna.indienest.backend.project.domain.model.valueobjects;

/**
 * AudioUrl Value Object
 */
public record AudioUrl(String url) {

    /**
     * Constructor with validation
     * @param url Audio Url
     */
    public AudioUrl {
        if (url == null || url.isBlank()){
            throw new IllegalArgumentException("url cannot be null or blank");
        }
    }
}
