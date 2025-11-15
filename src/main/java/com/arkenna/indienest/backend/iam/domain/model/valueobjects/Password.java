package com.arkenna.indienest.backend.iam.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record Password(
        @NotBlank
        @Column(name = "password")
        String password
)
{
    public Password() {
        this(null);
    }
}