package com.arkenna.indienest.backend.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record AccountId(Integer accountId) {

    public AccountId(){
        this(0);
    }

    public AccountId{
        if(accountId == null || accountId <= 0){
            throw new IllegalArgumentException("accountId can't be null or less than one");
        }
    }
}
