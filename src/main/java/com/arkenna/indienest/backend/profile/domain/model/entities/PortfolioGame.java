package com.arkenna.indienest.backend.profile.domain.model.entities;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Portfolio;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class PortfolioGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", referencedColumnName = "id", nullable = false)
    private Portfolio portfolio;

    @Column(name = "game_id", nullable = false)
    private Integer gameId;

    public PortfolioGame() {}

    public PortfolioGame(Portfolio portfolio, Integer gameId) {
        this.portfolio = portfolio;
        this.gameId = gameId;
    }
}
