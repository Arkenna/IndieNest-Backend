package com.arkenna.indienest.backend.payment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Game Id Value Object
 */
@Embeddable
public record GameId(Integer gameId) {

    /**
     * Constructor with validation
     * @param gameId The Game Id
     */
    public GameId {
        if (gameId == null || gameId < 1)
            throw new IllegalArgumentException("Game id cannot be null or less than 1");
    }
}
