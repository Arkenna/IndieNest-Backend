package com.arkenna.indienest.backend.payment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Profile ID Value Object
 */
@Embeddable
public record ProfileId(Integer profileId) {

    /**
     * Constructor with validation
     * @param profileId The Profile ID
     */
    public ProfileId {
        if (profileId == null || profileId < 1) {
            throw new IllegalArgumentException("Invalid profile id");
        }
    }
}
