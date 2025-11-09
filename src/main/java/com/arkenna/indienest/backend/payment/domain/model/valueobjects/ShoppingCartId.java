package com.arkenna.indienest.backend.payment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * ShoppingCart ID Value Object
 */
@Embeddable
public record ShoppingCartId(Integer shoppingCartId) {

    /**
     * Constructor with validation
     * @param shoppingCartId The ShoppingCart ID
     */
    public ShoppingCartId {
        if (shoppingCartId == null || shoppingCartId < 1) {
            throw new IllegalArgumentException("Shopping cart id cannot be null or less than 1");
        }
    }
}
