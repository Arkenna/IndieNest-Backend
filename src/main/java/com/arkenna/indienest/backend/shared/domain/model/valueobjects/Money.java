package com.arkenna.indienest.backend.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Money Value Object
 */
@Embeddable
public record Money(BigDecimal amount, String currency) {

    /**
     * Constructor with validation
     * @param amount Money amount
     * @param currency Money currency
     */
    public Money {
        Objects.requireNonNull(amount, "Amount cannot be null");
        Objects.requireNonNull(currency, "Currency cannot be null");
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Amount cannot be negative");
    }

    public static Money of(BigDecimal amount, String currency) {
        return new Money(amount, currency.toUpperCase());
    }

    public Money add(Money other) {
        ensureSameCurrency(other);
        return new Money(this.amount.add(other.amount), this.currency);
    }

    public Money subtract(Money other) {
        ensureSameCurrency(other);
        return new Money(this.amount.subtract(other.amount), this.currency);
    }

    public boolean isGreaterThan(Money other) {
        ensureSameCurrency(other);
        return this.amount.compareTo(other.amount) > 0;
    }

    private void ensureSameCurrency(Money other) {
        if (!this.currency.equals(other.currency))
            throw new IllegalArgumentException("Cannot operate on different currencies");
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

}
