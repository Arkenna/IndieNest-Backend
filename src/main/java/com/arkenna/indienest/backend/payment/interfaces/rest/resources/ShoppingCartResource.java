package com.arkenna.indienest.backend.payment.interfaces.rest.resources;

import java.math.BigDecimal;
import java.util.List;

public record ShoppingCartResource(Integer id, Integer profileId, BigDecimal price, List<ShoppingCartGameResource> items ) {
}
