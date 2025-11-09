package com.arkenna.indienest.backend.payment.interfaces.rest.transform;

import com.arkenna.indienest.backend.payment.domain.model.commands.CreateShoppingCartCommand;
import com.arkenna.indienest.backend.payment.interfaces.rest.resources.CreateShoppingCartResource;

public class CreateShoppingCartCommandFromResourceAssembler {

    public static CreateShoppingCartCommand toCommandFromResource(CreateShoppingCartResource resource){
        return new CreateShoppingCartCommand(resource.profileId(), resource.gameId(), resource.price());
    }
}
