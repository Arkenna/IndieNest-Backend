package com.arkenna.indienest.backend.community.domain.model.aggregates;

import com.arkenna.indienest.backend.community.domain.model.commands.CreatePublicationCommand;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.PublicationComment;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.PublicationImage;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.PublicationTitle;
import com.arkenna.indienest.backend.community.domain.model.valueobjects.UserId;
import com.arkenna.indienest.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

/**
 * Publication Aggregate Root
 */
@Entity
@Getter
public class Publication extends AuditableAbstractAggregateRoot<Publication> {

    @Embedded
    private UserId userId;

    @Embedded
    private PublicationTitle title;

    @Embedded
    private PublicationComment comment;

    @Embedded
    private PublicationImage image;

    /**
     * Default Constructor
     */
    public Publication(){}

    /**
     * Constructor with a CreatePublicationCommand
     * @param command The {@link CreatePublicationCommand} instance
     */
    public Publication(CreatePublicationCommand command){

        this.userId = new UserId(command.userId());
        this.title = new PublicationTitle(command.title());
        this.comment = new PublicationComment(command.comment());
    }
}
