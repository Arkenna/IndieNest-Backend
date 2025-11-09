package com.arkenna.indienest.backend.payment.domain.model.entities;
import com.arkenna.indienest.backend.payment.domain.model.aggregates.ShoppingCart;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
public class ShoppingCartGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id", nullable = false)
    private ShoppingCart shoppingCart;

    @Column(name = "game_id", nullable = false)
    private Integer gameId;

    public ShoppingCartGame() {}

    public ShoppingCartGame(ShoppingCart shoppingCart, Integer gameId) {
        this.shoppingCart = shoppingCart;
        this.gameId = gameId;
    }
}