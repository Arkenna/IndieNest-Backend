package com.arkenna.indienest.backend.project.interfaces.rest.resources;

/**
 * Resource for a Create Art Command
 */
public record CreateArtResource(Integer accountId,
                                String name,
                                String description,
                                Integer rating,
                                String image,
                                String category) {
}
