package com.arkenna.indienest.backend.project.domain.model.commands;

/**
 * Create Art Command
 */
public record CreateArtCommand(Integer authorId,
                               String name,
                               String description,
                               Integer rating,
                               String image,
                               String category) {
}
