package com.arkenna.indienest.backend.profile.infrastructure.persistence.jpa.repositories;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio,Integer>{
}
