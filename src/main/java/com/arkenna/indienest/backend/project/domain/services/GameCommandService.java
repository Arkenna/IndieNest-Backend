package com.arkenna.indienest.backend.project.domain.services;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Game;
import com.arkenna.indienest.backend.project.domain.model.commands.CreateGameCommand;

import java.util.Optional;

/**
 * Game Command Service
 */
public interface GameCommandService {

    /**
     * Handle Create Game Command
     *
     * @param command The {@link CreateGameCommand} Command
     * @return A {@link Game} instance if the command is valid, otherwise empty
     * @throws IllegalArgumentException if already exists a game with same authorId and name
     */
    Optional<Game> handle(CreateGameCommand command);
}
