package com.arkenna.indienest.backend.community.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * PublicationId Value Object
 */
@Embeddable
public record PublicationId(Integer publicationId) {

    /**
     * Constructor with validation
     * @param publicationId Publication Id
     */
    public PublicationId {
        if(publicationId == null || publicationId < 1)
            throw new IllegalArgumentException("Invalid publication id");
    }
}
