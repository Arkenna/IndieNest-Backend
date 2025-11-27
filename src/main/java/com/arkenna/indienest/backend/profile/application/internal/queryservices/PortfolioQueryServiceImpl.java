package com.arkenna.indienest.backend.profile.application.internal.queryservices;

import com.arkenna.indienest.backend.profile.domain.model.aggregates.Portfolio;
import com.arkenna.indienest.backend.profile.domain.model.queries.GetAllPortfoliosQuery;
import com.arkenna.indienest.backend.profile.domain.model.queries.GetPortfolioByIdQuery;
import com.arkenna.indienest.backend.profile.domain.services.PortfolioQueryService;
import com.arkenna.indienest.backend.profile.infrastructure.persistence.jpa.repositories.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioQueryServiceImpl implements PortfolioQueryService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioQueryServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<Portfolio> handle(GetAllPortfoliosQuery query){
        return this.portfolioRepository.findAll();
    }


    public Optional<Portfolio> handle(GetPortfolioByIdQuery query){
        return this.portfolioRepository.findById(query.id());
    }
}
