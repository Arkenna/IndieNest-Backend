package com.arkenna.indienest.backend.payment.application.internal.commandservices;

import com.arkenna.indienest.backend.payment.domain.model.aggregates.ShoppingCart;
import com.arkenna.indienest.backend.payment.domain.model.queries.GetAllShoppingCartsQuery;
import com.arkenna.indienest.backend.payment.domain.model.queries.GetShoppingCartByIdQuery;
import com.arkenna.indienest.backend.payment.domain.services.ShoppingCartQueryService;
import com.arkenna.indienest.backend.payment.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartQueryServiceImpl implements ShoppingCartQueryService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartQueryServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<ShoppingCart> handle(GetAllShoppingCartsQuery query){
        return this.shoppingCartRepository.findAll();
    }

    public Optional<ShoppingCart> handle(GetShoppingCartByIdQuery query){
        return this.shoppingCartRepository.findById(query.id());
    }

}
