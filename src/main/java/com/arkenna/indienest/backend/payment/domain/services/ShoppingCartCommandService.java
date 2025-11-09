package com.arkenna.indienest.backend.payment.domain.services;

import com.arkenna.indienest.backend.payment.domain.model.aggregates.ShoppingCart;
import com.arkenna.indienest.backend.payment.domain.model.commands.AddGameToShoppingCartCommand;
import com.arkenna.indienest.backend.payment.domain.model.commands.CreateShoppingCartCommand;
import com.arkenna.indienest.backend.payment.domain.model.commands.DeleteGameFromShoppingCartCommand;

import java.util.Optional;

/**
 * ShoppingCart Command Service
 */
public interface ShoppingCartCommandService {

    /**
     * Handle Create ShoppingCart Command
     * @param command The {@link CreateShoppingCartCommand} command
     * @return A {@link ShoppingCart} instance
     */
    Optional<ShoppingCart> handle(CreateShoppingCartCommand command);

    /**
     * Handle Add Game To ShoppingCart Command
     * @param command The {@link AddGameToShoppingCartCommand} command
     * @return A {@link ShoppingCart} instance
     */
    Optional<ShoppingCart> handle(AddGameToShoppingCartCommand command);

    /**
     * Handle Delete Game From ShoppingCart Command
     * @param command The {@link DeleteGameFromShoppingCartCommand} command
     * @return A {@link ShoppingCart} instance
     */
    Optional<ShoppingCart> handle(DeleteGameFromShoppingCartCommand command);
}
