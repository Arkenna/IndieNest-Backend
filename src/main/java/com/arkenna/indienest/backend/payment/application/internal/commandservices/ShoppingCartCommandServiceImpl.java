package com.arkenna.indienest.backend.payment.application.internal.commandservices;

import com.arkenna.indienest.backend.payment.domain.model.aggregates.ShoppingCart;
import com.arkenna.indienest.backend.payment.domain.model.commands.AddGameToShoppingCartCommand;
import com.arkenna.indienest.backend.payment.domain.model.commands.CreateShoppingCartCommand;
import com.arkenna.indienest.backend.payment.domain.model.commands.DeleteGameFromShoppingCartCommand;
import com.arkenna.indienest.backend.payment.domain.model.valueobjects.ProfileId;
import com.arkenna.indienest.backend.payment.domain.services.ShoppingCartCommandService;
import com.arkenna.indienest.backend.payment.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import com.arkenna.indienest.backend.shared.domain.model.valueobjects.Money;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartCommandServiceImpl implements ShoppingCartCommandService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartCommandServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public Optional<ShoppingCart> handle(CreateShoppingCartCommand command){

        var profileId = new ProfileId(command.profileId());
        var price = new Money(command.price(), "PEN");
        if(shoppingCartRepository.existsByProfileIdAndPrice(profileId, price)){
            throw new IllegalStateException("ShoppingCart with same ProfileId and Price already exists");
        }
        var shoppingCart = new ShoppingCart(command);
        shoppingCartRepository.save(shoppingCart);
        return Optional.of(shoppingCart);
    }

    public Optional<ShoppingCart> handle(AddGameToShoppingCartCommand command){

        var shoppingCartOptional = shoppingCartRepository.findById(command.shoppingCartId());
        if(shoppingCartOptional.isEmpty()){
            throw new IllegalArgumentException("ShoppingCart not found");
        }
        var shoppingCart = shoppingCartOptional.get();
        shoppingCart.addGame(command.gameId(), command.price());

        shoppingCartRepository.save(shoppingCart);
        return Optional.of(shoppingCart);
    }

    public Optional<ShoppingCart> handle(DeleteGameFromShoppingCartCommand command){

        var shoppingCartOptional = shoppingCartRepository.findById(command.shoppingCartId());
        if(shoppingCartOptional.isEmpty()){
            throw new IllegalArgumentException("ShoppingCart not found");
        }
        var shoppingCart = shoppingCartOptional.get();
        shoppingCart.removeGame(command.gameId(), command.price());

        shoppingCartRepository.save(shoppingCart);
        return Optional.of(shoppingCart);
    }

}
