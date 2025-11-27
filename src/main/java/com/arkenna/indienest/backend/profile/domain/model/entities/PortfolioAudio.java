package com.arkenna.indienest.backend.profile.domain.model.entities;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Portfolio;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class PortfolioAudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", referencedColumnName = "id", nullable = false)
    private Portfolio portfolio;

    @Column(name = "audio_id", nullable = false)
    private Integer audioId;

    public PortfolioAudio() {}

    public PortfolioAudio(Portfolio portfolio, Integer audioId) {
        this.portfolio = portfolio;
        this.audioId = audioId;
    }
}
