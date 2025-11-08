package com.arkenna.indienest.backend.project.domain.model.aggregates;

import com.arkenna.indienest.backend.project.domain.model.valueobjects.*;
import com.arkenna.indienest.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

/**
 * Project Abstract Aggregate Root
 */
@Getter
@MappedSuperclass
public class Project extends AuditableAbstractAggregateRoot<Project> {

    @Embedded
    protected AccountId accountId;

    @Embedded
    protected ProjectName name;

    @Embedded
    protected ProjectDescription description;

    @Embedded
    protected Rating rating;

    @Embedded
    protected ProjectImage image;

    /**
     * Default constructor
     */
    public Project() {}

    /**
     * Constructor with parameters
     * @param accountId Account Id
     * @param projectName Project Name
     * @param projectDescription Project Description
     * @param rating Rating
     * @param projectImage Project Image
     */
    public Project(Integer accountId,
                   String projectName,
                   String projectDescription,
                   Integer rating,
                   String projectImage){
        this.accountId = new AccountId(accountId);
        this.name = new ProjectName(projectName);
        this.description = new ProjectDescription(projectDescription);
        this.rating = new Rating(rating);
        this.image = new ProjectImage(projectImage);
    }

}
