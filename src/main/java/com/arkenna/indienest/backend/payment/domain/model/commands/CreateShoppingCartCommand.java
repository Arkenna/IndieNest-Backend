package com.arkenna.indienest.backend.payment.domain.model.commands;

import java.math.BigDecimal;

/**
 * Create ShoppingCart Command
 */
public record CreateShoppingCartCommand(Integer profileId, Integer gameId, BigDecimal price) {
}
