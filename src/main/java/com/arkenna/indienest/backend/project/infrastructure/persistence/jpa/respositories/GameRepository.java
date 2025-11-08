package com.arkenna.indienest.backend.project.infrastructure.persistence.jpa.respositories;

import com.arkenna.indienest.backend.project.domain.model.aggregates.Game;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.AccountId;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.ProjectName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Game Repository
 */
public interface GameRepository extends JpaRepository<Game,Integer> {

    /**
     * Find a Game by AccountId and Name
     * @param accountId The {@link AccountId} Account Id
     * @param name The {@link ProjectName} Project Name
     * @return True if the account id and the name exists, otherwise false
     */
    boolean existsByAccountIdAndName(AccountId accountId, ProjectName name);
}
