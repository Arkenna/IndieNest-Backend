package com.arkenna.indienest.backend.profile.domain.model.aggregates;

import com.arkenna.indienest.backend.profile.domain.model.commands.CreatePortfolioCommand;
import com.arkenna.indienest.backend.profile.domain.model.entities.PortfolioArt;
import com.arkenna.indienest.backend.profile.domain.model.entities.PortfolioAudio;
import com.arkenna.indienest.backend.profile.domain.model.entities.PortfolioGame;
import com.arkenna.indienest.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Portfolio Aggregate Root
 */
@Entity
@Getter
public class Portfolio extends AuditableAbstractAggregateRoot<Portfolio> {

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioGame> games = new ArrayList<>();

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioAudio> audios = new ArrayList<>();

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioArt> arts = new ArrayList<>();


    /**
     * Default Constructor
     */
    public Portfolio(){}

    public Portfolio(CreatePortfolioCommand command){
    }

    public void addGame(Integer gameId) {
        var game = new PortfolioGame(this, gameId);
        games.add(game);
    }

    public void addAudio(Integer audioId) {
        var audio = new PortfolioAudio(this, audioId);
        audios.add(audio);
    }

    public void addArt(Integer artId) {
        var art = new PortfolioArt(this, artId);
        arts.add(art);
    }

}
