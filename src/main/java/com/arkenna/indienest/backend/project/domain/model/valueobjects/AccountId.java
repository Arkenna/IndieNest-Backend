package com.arkenna.indienest.backend.project.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * AccountId Value Object
 */
@Embeddable
public record AccountId(Integer accountId) {

    /**
     * Constructor with validation
     * @param accountId AccountId
     */
    public AccountId {
        if(accountId < 1)
            throw new IllegalArgumentException("Invalid AccountId");
    }
}
