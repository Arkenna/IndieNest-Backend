package com.arkenna.indienest.backend.project.domain.services;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Audio;
import com.arkenna.indienest.backend.project.domain.model.commands.CreateAudioCommand;

import java.util.Optional;

/**
 * Audio Command Service
 */
public interface AudioCommandService {

    /**
     * Handle Create Audio Command
     *
     * @param command The {@link CreateAudioCommand} Command
     * @return A {@link Audio} instance if the command is valid, otherwise empty
     * @throws IllegalArgumentException if already exists an audio with same authorId and name
     */
    Optional<Audio> handle(CreateAudioCommand command);
}
