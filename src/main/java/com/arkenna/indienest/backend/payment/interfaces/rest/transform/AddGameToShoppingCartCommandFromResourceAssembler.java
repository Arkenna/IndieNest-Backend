package com.arkenna.indienest.backend.payment.interfaces.rest.transform;

import com.arkenna.indienest.backend.payment.domain.model.commands.AddGameToShoppingCartCommand;
import com.arkenna.indienest.backend.payment.interfaces.rest.resources.AddGameToShoppingCartResource;

public class AddGameToShoppingCartCommandFromResourceAssembler {

    public static AddGameToShoppingCartCommand toCommandFromResource(AddGameToShoppingCartResource resource ) {
        return new AddGameToShoppingCartCommand(resource.shoppingCartId(), resource.gameId(), resource.price());
    }
}
