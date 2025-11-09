package com.arkenna.indienest.backend.community.domain.services;

import com.arkenna.indienest.backend.community.domain.model.aggregates.Publication;
import com.arkenna.indienest.backend.community.domain.model.commands.CreatePublicationCommand;

import java.util.Optional;

/**
 * Publication Command Service
 */
public interface PublicationCommandService {

    /**
     * Handle Create Publication Command
     * @param command The {@link CreatePublicationCommand} Command
     * @return A {@link Publication} instance if the command is valid, otherwise empty
     * @throws IllegalArgumentException if already exists a Publication with same UserId and Title
     */
    Optional<Publication> handle(CreatePublicationCommand command);
}
