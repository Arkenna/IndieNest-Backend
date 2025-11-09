package com.arkenna.indienest.backend.community.domain.model.aggregates;

import com.arkenna.indienest.backend.community.domain.model.commands.CreateAnswerCommand;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.AnswerComment;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.PublicationId;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.UserId;
import com.arkenna.indienest.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

/**
 * Answer Aggregate Root
 */
@Entity
@Getter
public class Answer extends AuditableAbstractAggregateRoot<Answer> {

    @Embedded
    private UserId userId;

    @Embedded
    private PublicationId publicationId;

    @Embedded
    private AnswerComment comment;

    /**
     * Default Constructor
     */
    public Answer(){}

    /**
     * Constructor with a CreateAnswerCommand
     * @param command The {@link CreateAnswerCommand} instance
     */
    public Answer(CreateAnswerCommand command){
        this.userId = new UserId(command.userId());
        this.publicationId = new PublicationId(command.publicationId());
        this.comment = new AnswerComment(command.comment());
    }
}
