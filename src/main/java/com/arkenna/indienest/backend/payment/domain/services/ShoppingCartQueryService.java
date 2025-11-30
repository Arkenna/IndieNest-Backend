package com.arkenna.indienest.backend.payment.domain.services;

import com.arkenna.indienest.backend.payment.domain.model.aggregates.ShoppingCart;
import com.arkenna.indienest.backend.payment.domain.model.queries.GetAllShoppingCartsQuery;
import com.arkenna.indienest.backend.payment.domain.model.queries.GetShoppingCartByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * ShoppingCart Query Service
 */
public interface ShoppingCartQueryService {

    /**
     * Handle Get All ShoppingCarts Query
     * @param query The {@link GetAllShoppingCartsQuery} query
     * @return A List of {@link ShoppingCart} instances
     */
    List<ShoppingCart> handle(GetAllShoppingCartsQuery query);

    /**
     * Handle Get A ShoppingCart By Id Query
     * @param query The {@link GetShoppingCartByIdQuery} query
     * @return A {@link ShoppingCart} instance
     */
    Optional<ShoppingCart> handle(GetShoppingCartByIdQuery query);
}
