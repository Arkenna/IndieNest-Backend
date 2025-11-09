package com.arkenna.indienest.backend.payment.domain.model.aggregates;
import com.arkenna.indienest.backend.payment.domain.model.commands.CreateShoppingCartCommand;
import com.arkenna.indienest.backend.payment.domain.model.entities.ShoppingCartGame;
import com.arkenna.indienest.backend.payment.domain.model.valueobjects.ProfileId;
import com.arkenna.indienest.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.arkenna.indienest.backend.shared.domain.model.valueobjects.Money;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart Aggregate Root
 */
@Entity
@Getter
public class ShoppingCart extends AuditableAbstractAggregateRoot<ShoppingCart> {

    @Embedded
    private ProfileId profileId;

    @Embedded
    private Money price;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShoppingCartGame> items = new ArrayList<>();

    /**
     * Default Constructor
     */
    public ShoppingCart(){}


    public ShoppingCart(CreateShoppingCartCommand command){
        this.profileId = new ProfileId(command.profileId());
        this.price = new Money(command.price(), "PEN");
        var firstItem = new ShoppingCartGame(this, command.gameId());
        this.items.add(firstItem);
    }

    public void addGame(Integer gameId , BigDecimal gamePrice) {
        var item = new ShoppingCartGame(this, gameId);
        items.add(item);
        this.price = this.price.add(new Money(gamePrice, "PEN"));
    }

    public void removeGame(Integer gameId, BigDecimal gamePrice) {
        items.removeIf(item -> item.getGameId().equals(gameId));
        this.price = this.price.subtract(new Money(gamePrice, "PEN"));
    }

}
