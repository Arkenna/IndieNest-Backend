package com.arkenna.indienest.backend.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record GameId(Integer gameId) {

    public GameId(){
        this(0);
    }

    public GameId{
        if(gameId == null || gameId < 1){
            throw new IllegalArgumentException("Game ID cannot be null or less than 1");
        }
    }
}
