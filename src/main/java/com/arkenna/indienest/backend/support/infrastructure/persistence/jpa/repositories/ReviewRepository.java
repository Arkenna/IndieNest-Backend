package com.arkenna.indienest.backend.support.infrastructure.persistence.jpa.repositories;

import com.arkenna.indienest.backend.support.domain.model.aggregates.Review;
import com.arkenna.indienest.backend.support.domain.model.valueobjects.ReviewComment;
import com.arkenna.indienest.backend.support.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {

    boolean existsByUserIdAndComment(UserId userId, ReviewComment comment);
}
