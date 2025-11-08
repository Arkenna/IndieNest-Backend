package com.arkenna.indienest.backend.project.domain.model.aggregates;

import com.arkenna.indienest.backend.project.domain.model.commands.CreateGameCommand;
import com.arkenna.indienest.backend.project.domain.model.valueobjects.GameCategory;
import com.arkenna.indienest.backend.shared.domain.model.valueobjects.Money;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

/**
 * Game Aggregate Root
 */
@Entity
@Getter
public class Game extends Project {

    @Embedded
    private Money price;

    @Embedded
    private GameCategory category;

    /**
     * Default constructor
     */
    public Game(){}

    /**
     * Constructor with a CreateGameCommand
     * @param command The {@link CreateGameCommand} instance
     */
    public Game(CreateGameCommand command){
        super(command.authorId(), command.name(), command.description(), command.rating(), command.image());
        this.price = new Money(command.price(), "PEN");
        this.category = GameCategory.valueOf(command.category());
    }
}
