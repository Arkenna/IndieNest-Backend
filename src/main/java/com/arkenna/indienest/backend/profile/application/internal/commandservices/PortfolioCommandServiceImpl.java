package com.arkenna.indienest.backend.profile.application.internal.commandservices;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Portfolio;
import com.arkenna.indienest.backend.profile.domain.model.commands.AddArtToPortfolioCommand;
import com.arkenna.indienest.backend.profile.domain.model.commands.AddAudioToPortfolioCommand;
import com.arkenna.indienest.backend.profile.domain.model.commands.AddGameToPortfolioCommand;
import com.arkenna.indienest.backend.profile.domain.model.commands.CreatePortfolioCommand;
import com.arkenna.indienest.backend.profile.domain.services.PortfolioCommandService;
import com.arkenna.indienest.backend.profile.infrastructure.persistence.jpa.repositories.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioCommandServiceImpl implements PortfolioCommandService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioCommandServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public Optional<Portfolio> handle(CreatePortfolioCommand command){
        var portfolio = new Portfolio(command);
        portfolioRepository.save(portfolio);
        return Optional.of(portfolio);
    }


    public Optional<Portfolio> handle(AddGameToPortfolioCommand command){

        var portfolioOptional = portfolioRepository.findById(command.portfolioId());
        if(portfolioOptional.isEmpty()){
            throw new IllegalArgumentException("Portfolio not found");
        }

        var portfolio = portfolioOptional.get();
        portfolio.addGame(command.gameId());

        portfolioRepository.save(portfolio);
        return Optional.of(portfolio);
    }


    public Optional<Portfolio> handle(AddAudioToPortfolioCommand command){
        var portfolioOptional = portfolioRepository.findById(command.portfolioId());
        if(portfolioOptional.isEmpty()){
            throw new IllegalArgumentException("Portfolio not found");
        }

        var portfolio = portfolioOptional.get();
        portfolio.addAudio(command.audioId());

        portfolioRepository.save(portfolio);
        return Optional.of(portfolio);
    }


    public Optional<Portfolio> handle(AddArtToPortfolioCommand command){
        var portfolioOptional = portfolioRepository.findById(command.portfolioId());
        if(portfolioOptional.isEmpty()){
            throw new IllegalArgumentException("Portfolio not found");
        }

        var portfolio = portfolioOptional.get();
        portfolio.addArt(command.artId());

        portfolioRepository.save(portfolio);
        return Optional.of(portfolio);
    }
}
