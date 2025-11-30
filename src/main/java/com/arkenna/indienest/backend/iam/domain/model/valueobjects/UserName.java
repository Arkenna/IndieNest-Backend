package com.arkenna.indienest.backend.iam.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record UserName(
        @NotBlank
        @Column(name = "name")
        String name
) {
    public UserName() {
        this(null);
    }
}