package com.arkenna.indienest.backend.community.infrastructure.persistence.jpa.repositories;

import com.arkenna.indienest.backend.community.domain.model.aggregates.Publication;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.PublicationTitle;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Publication Repository
 */
@Repository
public interface PublicationRepository extends JpaRepository<Publication,Integer> {

    /**
     * Check if an Answer exists by User Id and Comment
     * @param userId The {@link UserId} Value Object
     * @param title The {@link PublicationTitle} Value Object
     * @return True if the UserId and the Title exists, otherwise false
     */
    boolean existsByUserIdAndTitle(UserId userId, PublicationTitle title);
}
