package com.arkenna.indienest.backend.iam.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record PhoneNumber(
        @Column(name = "phone_number")
        String phoneNumber
) {
    public PhoneNumber() {
        this(null);
    }
}