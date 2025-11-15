package com.arkenna.indienest.backend.iam.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public record UserId(Integer userId) implements Serializable {

    public UserId() {
        this(0); // Default para Integer
    }

    public UserId {
        if (userId < 0) {
            throw new IllegalArgumentException("User id cannot be negative");
        }
    }
}