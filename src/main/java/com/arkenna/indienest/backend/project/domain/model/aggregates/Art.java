package com.arkenna.indienest.backend.project.domain.model.aggregates;

import com.arkenna.indienest.backend.project.domain.model.commands.CreateArtCommand;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.ArtCategory;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.GameCategory;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

/**
 * Art Aggregate Root
 */
@Entity
@Getter
public class Art extends Project {

    @Embedded
    private ArtCategory category;

    /**
     * Default constructor
     */
    public Art(){}

    /**
     * Constructor with a CreateArtCommand
     * @param command The {@link CreateArtCommand} instance
     */
    public Art(CreateArtCommand command){
        super(command.authorId(), command.name(), command.description(), command.rating(), command.image());
        this.category = ArtCategory.valueOf(command.category());
    }
}
