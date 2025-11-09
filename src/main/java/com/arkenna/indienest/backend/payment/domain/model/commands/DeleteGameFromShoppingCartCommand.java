package com.arkenna.indienest.backend.payment.domain.model.commands;

/**
 * Delete Game From ShoppingCart Command
 */
public record DeleteGameFromShoppingCartCommand(Integer shoppingCartId, Integer gameId) {
}
