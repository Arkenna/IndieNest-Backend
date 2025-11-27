package com.arkenna.indienest.backend.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record AudioId(Integer audioId) {

    public AudioId(){
        this(0);
    }

    public AudioId {
        if(audioId == 0 || audioId < 1){
            throw new IllegalArgumentException("Audio ID cannot be null or less than 1");
        }
    }
}
