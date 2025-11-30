package com.arkenna.indienest.backend.profile.domain.services;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Portfolio;
import com.arkenna.indienest.backend.profile.domain.model.commands.AddArtToPortfolioCommand;
import com.arkenna.indienest.backend.profile.domain.model.commands.AddAudioToPortfolioCommand;
import com.arkenna.indienest.backend.profile.domain.model.commands.AddGameToPortfolioCommand;
import com.arkenna.indienest.backend.profile.domain.model.commands.CreatePortfolioCommand;

import java.util.Optional;

/**
 * Portfolio Command Service
 */
public interface PortfolioCommandService {

    /**
     * Handle Create Portfolio Command
     * @param command The {@link CreatePortfolioCommand} command
     * @return A {@link Portfolio} instance
     */
    Optional<Portfolio> handle(CreatePortfolioCommand command);

    /**
     * Handle Add Game To Portfolio Command
     * @param command The {@link AddGameToPortfolioCommand} command
     * @return A {@link Portfolio} instance
     */
    Optional<Portfolio> handle(AddGameToPortfolioCommand command);

    /**
     * Handle Add Game To Portfolio Command
     * @param command The {@link AddAudioToPortfolioCommand} command
     * @return A {@link Portfolio} instance
     */
    Optional<Portfolio> handle(AddAudioToPortfolioCommand command);

    /**
     * Handle Add Game To Portfolio Command
     * @param command The {@link AddArtToPortfolioCommand} command
     * @return A {@link Portfolio} instance
     */
    Optional<Portfolio> handle(AddArtToPortfolioCommand command);

}
