package com.arkenna.indienest.backend.payment.infrastructure.persistence.jpa.repositories;

import com.arkenna.indienest.backend.payment.domain.model.aggregates.ShoppingCart;
import com.arkenna.indienest.backend.payment.domain.model.valueobjects.ProfileId;
import com.arkenna.indienest.backend.shared.domain.model.valueobjects.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {

    boolean existsByProfileIdAndPrice(ProfileId profileId, Money price);
}
