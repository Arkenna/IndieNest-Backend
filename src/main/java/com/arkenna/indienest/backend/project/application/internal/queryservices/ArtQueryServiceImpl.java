package com.arkenna.indienest.backend.project.application.internal.queryservices;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Art;
import com.arkenna.indienest.backend.project.domain.model.queries.GetAllArtsQuery;
import com.arkenna.indienest.backend.project.domain.model.queries.GetArtByIdQuery;
import com.arkenna.indienest.backend.project.domain.services.ArtQueryService;
import com.arkenna.indienest.backend.project.infrastructure.persistence.jpa.respositories.ArtRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Art Query Service Implementation
 */
@Service
public class ArtQueryServiceImpl implements ArtQueryService {

    private final ArtRepository artRepository;

    /**
     * Constructor
     * @param artRepository The {@link ArtRepository} instance
     */
    public ArtQueryServiceImpl(ArtRepository artRepository) {
        this.artRepository = artRepository;
    }

    //inherited javadoc
    @Override
    public List<Art> handle(GetAllArtsQuery query){
        return this.artRepository.findAll();
    }

    //inherited javadoc
    @Override
    public Optional<Art> handle(GetArtByIdQuery query){
        return this.artRepository.findById(query.id());
    }

}
