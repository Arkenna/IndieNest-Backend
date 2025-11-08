package com.arkenna.indienest.backend.project.interfaces.rest.resources;

/**
 * Resource for an Art
 */
public record ArtResource(Integer id,
                          Integer accountId,
                          String name,
                          String description,
                          Integer rating,
                          String image,
                          String category) {
}
