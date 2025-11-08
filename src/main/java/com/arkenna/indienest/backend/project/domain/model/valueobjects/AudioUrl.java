package com.arkenna.indienest.backend.project.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * AudioUrl Value Object
 */
@Embeddable
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
