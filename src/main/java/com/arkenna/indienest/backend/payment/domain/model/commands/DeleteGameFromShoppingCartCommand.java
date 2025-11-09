package com.arkenna.indienest.backend.payment.domain.model.commands;

import java.math.BigDecimal;

/**
 * Delete Game From ShoppingCart Command
 */
public record DeleteGameFromShoppingCartCommand(Integer shoppingCartId, Integer gameId, BigDecimal price) {
}
