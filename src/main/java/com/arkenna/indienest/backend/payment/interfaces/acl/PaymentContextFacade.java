package com.arkenna.indienest.backend.payment.interfaces.acl;

import java.math.BigDecimal;

public interface PaymentContextFacade {

    Integer createShoppingCart(Integer profileId, Integer gameId, BigDecimal price);
}
