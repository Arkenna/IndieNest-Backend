package com.arkenna.indienest.backend.payment.domain.model.commands;


/**
 * Add Game To Shopping Cart Command
 */
public record AddGameToShoppingCartCommand(Integer shoppingCartId, Integer gameId) {
}
