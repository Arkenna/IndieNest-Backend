package com.arkenna.indienest.backend.project.domain.model.valueobjects;

/**
 * AccountId Value Object
 */
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
