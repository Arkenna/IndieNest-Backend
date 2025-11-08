package com.arkenna.indienest.backend.project.domain.services;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Art;
import com.arkenna.indienest.backend.project.domain.model.aggregates.Game;
import com.arkenna.indienest.backend.project.domain.model.commands.CreateArtCommand;
import com.arkenna.indienest.backend.project.domain.model.commands.CreateGameCommand;

import java.util.Optional;

/**
 * Art Command Service
 */
public interface ArtCommandService {

    /**
     * Handle Create Art Command
     *
     * @param command The {@link CreateArtCommand} Command
     * @return A {@link Art} instance if the command is valid, otherwise empty
     * @throws IllegalArgumentException if already exists an art with same authorId and name
     */
    Optional<Art> handle(CreateArtCommand command);
}
