package com.arkenna.indienest.backend.project.domain.model.commands;

import java.math.BigDecimal;

/**
 * Create Game Command
 */
public record CreateGameCommand(Integer authorId,
                                String name,
                                String description,
                                Integer rating,
                                String image,
                                String category,
                                BigDecimal price) {
}
