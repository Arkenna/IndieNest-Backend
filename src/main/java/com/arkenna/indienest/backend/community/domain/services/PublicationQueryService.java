package com.arkenna.indienest.backend.community.domain.services;


import com.arkenna.indienest.backend.community.domain.model.aggregates.Publication;
import com.arkenna.indienest.backend.community.domain.model.queries.GetAllPublicationsQuery;
import com.arkenna.indienest.backend.community.domain.model.queries.GetPublicationByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * Publication Query Service
 */
public interface PublicationQueryService {

    /**
     * Handle Get All Publications Query
     * @param query The {@link GetAllPublicationsQuery} Query
     * @return A List of {@link Publication} instances
     */
    List<Publication> handle(GetAllPublicationsQuery query);

    /**
     * Get Publication By Id Query
     * @param query The {@link GetPublicationByIdQuery} Query
     * @return A {@link Publication} instance if the query is valid, otherwise empty
     */
    Optional<Publication> handle(GetPublicationByIdQuery query);
}
