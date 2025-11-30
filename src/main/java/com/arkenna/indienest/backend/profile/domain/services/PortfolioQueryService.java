package com.arkenna.indienest.backend.profile.domain.services;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Portfolio;
import com.arkenna.indienest.backend.profile.domain.model.queries.GetAllPortfoliosQuery;
import com.arkenna.indienest.backend.profile.domain.model.queries.GetPortfolioByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * Portfolio Query Service
 */
public interface PortfolioQueryService {

    /**
     * Handle Get All Portfolios Query
     * @param query The {@link GetAllPortfoliosQuery} query
     * @return A List of {@link Portfolio} instances
     */
    List<Portfolio> handle(GetAllPortfoliosQuery query);

    /**
     * Handle Get Portfolio By ID Query
     * @param query The {@link GetPortfolioByIdQuery} query
     * @return A {@link Portfolio} instance
     */
    Optional<Portfolio> handle(GetPortfolioByIdQuery query);
}
