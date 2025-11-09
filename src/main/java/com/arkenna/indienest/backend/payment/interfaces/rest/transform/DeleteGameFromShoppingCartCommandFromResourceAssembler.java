package com.arkenna.indienest.backend.payment.interfaces.rest.transform;

import com.arkenna.indienest.backend.payment.domain.model.commands.DeleteGameFromShoppingCartCommand;
import com.arkenna.indienest.backend.payment.interfaces.rest.resources.DeleteGameFromShoppingCartResource;

public class DeleteGameFromShoppingCartCommandFromResourceAssembler {

    public static DeleteGameFromShoppingCartCommand toCommandFromResource(DeleteGameFromShoppingCartResource resource) {
        return new DeleteGameFromShoppingCartCommand(resource.shoppingCartId(), resource.gameId(), resource.price());
    }
}
