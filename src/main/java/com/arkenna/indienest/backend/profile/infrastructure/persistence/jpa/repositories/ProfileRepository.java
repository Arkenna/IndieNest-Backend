package com.arkenna.indienest.backend.profile.infrastructure.persistence.jpa.repositories;

import com.arkenna.indienest.backend.payment.domain.model.aggregates.ShoppingCart;
import com.arkenna.indienest.backend.profile.domain.model.aggregates.Profile;
import com.arkenna.indienest.backend.profile.domain.model.valueobjects.AccountId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {

    boolean existsByAccountId(AccountId accountId);
}
