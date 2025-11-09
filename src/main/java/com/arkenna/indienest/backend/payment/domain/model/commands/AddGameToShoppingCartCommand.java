package com.arkenna.indienest.backend.payment.domain.model.commands;


import java.math.BigDecimal;

/**
 * Add Game To Shopping Cart Command
 */
public record AddGameToShoppingCartCommand(Integer shoppingCartId, Integer gameId, BigDecimal price) {
}
