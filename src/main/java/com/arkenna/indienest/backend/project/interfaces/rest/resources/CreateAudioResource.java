package com.arkenna.indienest.backend.project.interfaces.rest.resources;

/**
 * Resource for a Create Audio Command
 */
public record CreateAudioResource(Integer accountId,
                                  String name,
                                  String description,
                                  Integer rating,
                                  String image,
                                  String audioUrl,
                                  String format,
                                  String category) {
}
