package com.arkenna.indienest.backend.payment.interfaces.rest.resources;

import java.math.BigDecimal;

public record DeleteGameFromShoppingCartResource(Integer shoppingCartId, Integer gameId, BigDecimal price) {
}
