package com.arkenna.indienest.backend.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileImage(String image) {

    public ProfileImage(){
        this(null);
    }

    public ProfileImage {
        if(image != null && image.isBlank()){
            throw new IllegalArgumentException("Profile image must not be empty");
        }
    }
}
