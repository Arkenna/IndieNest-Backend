package com.arkenna.indienest.backend.payment.interfaces.rest.transform;

import com.arkenna.indienest.backend.payment.domain.model.aggregates.ShoppingCart;
import com.arkenna.indienest.backend.payment.interfaces.rest.resources.ShoppingCartResource;

public class ShoppingCartResourceFromEntityAssembler {

    public static ShoppingCartResource toResourceFromEntity(ShoppingCart entity) {
        return new ShoppingCartResource(
                entity.getId(),
                entity.getProfileId().profileId(),
                entity.getPrice().amount(),
                entity.getItems().stream().map(ShoppingCartGameResourceFromEntityAssembler::toResourceFromEntity).toList());
    }
}
