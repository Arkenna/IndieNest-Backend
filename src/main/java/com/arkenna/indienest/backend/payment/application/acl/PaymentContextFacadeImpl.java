package com.arkenna.indienest.backend.payment.application.acl;

import com.arkenna.indienest.backend.payment.domain.model.aggregates.ShoppingCart;
import com.arkenna.indienest.backend.payment.domain.model.commands.CreateShoppingCartCommand;
import com.arkenna.indienest.backend.payment.domain.services.ShoppingCartCommandService;
import com.arkenna.indienest.backend.payment.interfaces.acl.PaymentContextFacade;

import java.math.BigDecimal;

public class PaymentContextFacadeImpl implements PaymentContextFacade {

    ShoppingCartCommandService shoppingCartCommandService;

    public PaymentContextFacadeImpl(ShoppingCartCommandService shoppingCartCommandService) {
        this.shoppingCartCommandService = shoppingCartCommandService;
    }

    public Integer createShoppingCart(Integer profileId, Integer gameId, BigDecimal price) {

        var createShoppingCartCommand = new CreateShoppingCartCommand(profileId, gameId, price);
        var shoppingCart = this.shoppingCartCommandService.handle(createShoppingCartCommand);
        return shoppingCart.isEmpty() ? 0 : shoppingCart.get().getId();
    }
}
