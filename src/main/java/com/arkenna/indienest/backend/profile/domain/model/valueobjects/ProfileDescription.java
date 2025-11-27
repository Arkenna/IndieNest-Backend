package com.arkenna.indienest.backend.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileDescription(String description) {

    public ProfileDescription(){
        this(null);
    }

    public ProfileDescription {
        if(description == null || description.isBlank()){
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
    }
}
