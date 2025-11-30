package com.arkenna.indienest.backend.payment.interfaces.rest.transform;

import com.arkenna.indienest.backend.payment.domain.model.entities.ShoppingCartGame;
import com.arkenna.indienest.backend.payment.interfaces.rest.resources.ShoppingCartGameResource;

public class ShoppingCartGameResourceFromEntityAssembler {

    public static ShoppingCartGameResource toResourceFromEntity(ShoppingCartGame entity) {
        return new ShoppingCartGameResource(entity.getId(), entity.getShoppingCart().getId(), entity.getGameId());
    }
}
