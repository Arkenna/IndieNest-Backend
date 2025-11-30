package com.arkenna.indienest.backend.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ArtId(Integer artId) {

    public ArtId(){
        this(0);
    }

    public ArtId {
        if(artId == null || artId < 1){
            throw new IllegalArgumentException("Art ID cannot be null or less than 1");
        }
    }
}
