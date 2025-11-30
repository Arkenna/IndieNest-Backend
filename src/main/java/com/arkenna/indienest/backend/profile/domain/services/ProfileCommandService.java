package com.arkenna.indienest.backend.profile.domain.services;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Profile;
import com.arkenna.indienest.backend.profile.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

/**
 * Profile Command Service
 */
public interface ProfileCommandService {

    /**
     * Handle Create Profile Command
     * @param command The {@link CreateProfileCommand} command
     * @return a {@link Profile} instance
     */
    Optional<Profile> handle(CreateProfileCommand command);
}
