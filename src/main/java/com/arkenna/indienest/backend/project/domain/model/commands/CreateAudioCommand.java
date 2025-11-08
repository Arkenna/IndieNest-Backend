package com.arkenna.indienest.backend.project.domain.model.commands;

/**
 * Create Audio Command
 */
public record CreateAudioCommand(Integer authorId,
                                 String name,
                                 String description,
                                 Integer rating,
                                 String image,
                                 String category,
                                 String audioUrl,
                                 String audioFormat) {
}
