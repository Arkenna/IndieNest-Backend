package com.arkenna.indienest.backend.payment.interfaces.rest.resources;

import java.math.BigDecimal;

public record CreateShoppingCartResource(Integer profileId, Integer gameId, BigDecimal price) {
}
