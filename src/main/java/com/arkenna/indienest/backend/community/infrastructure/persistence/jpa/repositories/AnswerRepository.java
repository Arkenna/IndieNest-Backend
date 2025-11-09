package com.arkenna.indienest.backend.community.infrastructure.persistence.jpa.repositories;

import com.arkenna.indienest.backend.community.domain.model.aggregates.Answer;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.AnswerComment;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Answer Repository
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    /**
     * Check if an Answer exists by User Id and Comment
     * @param userId The {@link UserId} Value Object
     * @param comment The {@link AnswerComment} Value Object
     * @return True if the UserId and the Comment exists, otherwise false
     */
    boolean existsByUserIdAndComment(UserId userId, AnswerComment comment);

}
