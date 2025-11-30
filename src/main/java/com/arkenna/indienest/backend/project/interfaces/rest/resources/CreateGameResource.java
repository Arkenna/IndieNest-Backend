package com.arkenna.indienest.backend.project.interfaces.rest.resources;

import java.math.BigDecimal;

/**
 * Resource for a Create Game command
 */
public record CreateGameResource(Integer accountId,
                                 String name,
                                 String description,
                                 Integer rating,
                                 String image,
                                 BigDecimal price,
                                 String category) {
}
