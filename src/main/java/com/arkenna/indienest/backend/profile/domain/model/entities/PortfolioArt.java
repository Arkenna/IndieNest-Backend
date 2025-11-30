package com.arkenna.indienest.backend.profile.domain.model.entities;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Portfolio;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class PortfolioArt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", referencedColumnName = "id", nullable = false)
    private Portfolio portfolio;

    @Column(name = "art_id", nullable = false)
    private Integer artId;

    public PortfolioArt() {}

    public PortfolioArt(Portfolio portfolio, Integer artId) {
        this.portfolio = portfolio;
        this.artId = artId;
    }
}
