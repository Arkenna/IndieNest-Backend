package com.arkenna.indienest.backend.profile.domain.model.aggregates;

import com.arkenna.indienest.backend.profile.domain.model.commands.CreateProfileCommand;
import com.arkenna.indienest.backend.profile.domain.model.valueobjects.AccountId;
import com.arkenna.indienest.backend.profile.domain.model.valueobjects.PortfolioId;
import com.arkenna.indienest.backend.profile.domain.model.valueobjects.ProfileDescription;
import com.arkenna.indienest.backend.profile.domain.model.valueobjects.ProfileImage;
import com.arkenna.indienest.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

/**
 * Profile Aggregate Root
 */
@Entity
@Getter
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    private AccountId accountId;

    @Embedded
    private PortfolioId portfolioId;

    @Embedded
    private ProfileDescription description;

    @Embedded
    private ProfileImage image;

    /**
     * Default Constructor
     */
    public Profile(){}

    /**
     * Constructor with a CreateProfileCommand
     * @param command The {@link CreateProfileCommand} command
     */
    public Profile(CreateProfileCommand command){
        accountId = new AccountId(command.accountId());
        portfolioId = new PortfolioId(command.portfolioId());
        description = new ProfileDescription(command.description());
        image = new ProfileImage(command.image());
    }
}
