package com.arkenna.indienest.backend.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PortfolioId(Integer portfolioId) {

    public PortfolioId(){
        this(0);
    }
}
