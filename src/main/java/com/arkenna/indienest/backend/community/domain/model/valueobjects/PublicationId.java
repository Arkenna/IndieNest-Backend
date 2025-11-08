package com.arkenna.indienest.backend.community.domain.model.valueobjects;

/**
 * PublicationId Value Object
 */
public record PublicationId(Integer publicationId) {

    /**
     * Constructor with validation
     * @param publicationId Publication Id
     */
    public PublicationId {
        if(publicationId == null || publicationId < 0)
            throw new IllegalArgumentException("Invalid publication id");
    }
}
