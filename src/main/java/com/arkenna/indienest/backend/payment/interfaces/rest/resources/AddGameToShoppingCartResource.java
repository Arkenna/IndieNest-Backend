package com.arkenna.indienest.backend.payment.interfaces.rest.resources;

import java.math.BigDecimal;

public record AddGameToShoppingCartResource(Integer shoppingCartId, Integer gameId, BigDecimal price) {
}
