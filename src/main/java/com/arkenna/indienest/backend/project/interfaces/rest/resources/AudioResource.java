package com.arkenna.indienest.backend.project.interfaces.rest.resources;

/**
 * Resource for an Audio
 */
public record AudioResource(Integer id,
                            Integer accountId,
                            String name,
                            String description,
                            Integer rating,
                            String image,
                            String audioUrl,
                            String format,
                            String category) {
}
