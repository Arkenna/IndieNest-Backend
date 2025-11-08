package com.arkenna.indienest.backend.project.interfaces.rest.resources;

import java.math.BigDecimal;

/**
 * Resource for a Game
 */
public record GameResource(Integer id,
                           Integer accountId,
                           String name,
                           String description,
                           Integer rating,
                           String image,
                           BigDecimal price,
                           String category) {
}
