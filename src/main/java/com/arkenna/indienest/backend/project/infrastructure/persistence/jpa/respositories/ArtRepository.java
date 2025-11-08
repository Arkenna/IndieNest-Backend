package com.arkenna.indienest.backend.project.infrastructure.persistence.jpa.respositories;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Art;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.AccountId;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.ProjectName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Art Repository
 */
@Repository
public interface ArtRepository extends JpaRepository<Art,Integer> {

    /**
     * Check if and Audio exists by Account Id and Name
     * @param accountId The {@link AccountId} Value Object
     * @param name The {@link ProjectName} Value Object
     * @return True if the account id and the name exists, otherwise false
     */
    boolean existsByAccountIdAndName(AccountId accountId, ProjectName name);
}
