package com.arkenna.indienest.backend.community.application.internal.queryservices;

import com.arkenna.indienest.backend.community.domain.model.aggregates.Publication;
import com.arkenna.indienest.backend.community.domain.model.queries.GetAllPublicationsQuery;
import com.arkenna.indienest.backend.community.domain.model.queries.GetPublicationByIdQuery;
import com.arkenna.indienest.backend.community.domain.services.PublicationQueryService;
import com.arkenna.indienest.backend.community.infrastructure.persistence.jpa.repositories.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Publication Query Service Implementation
 */
@Service
public class PublicationQueryServiceImpl implements PublicationQueryService {

    private final PublicationRepository PublicationRepository;

    /**
     * Constructor
     *
     * @param PublicationRepository The {@link PublicationRepository} instance
     */
    public PublicationQueryServiceImpl(PublicationRepository PublicationRepository) {
        this.PublicationRepository = PublicationRepository;
    }

    //inherited javadoc
    @Override
    public List<Publication> handle(GetAllPublicationsQuery query) {
        return this.PublicationRepository.findAll();
    }

    //inherited javadoc
    @Override
    public Optional<Publication> handle(GetPublicationByIdQuery query) {
        return this.PublicationRepository.findById(query.id());
    }
}
