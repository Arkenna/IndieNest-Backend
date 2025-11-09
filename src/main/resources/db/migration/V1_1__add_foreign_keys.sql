ALTER TABLE answers
    ADD CONSTRAINT FK_answers_publication_id FOREIGN KEY (publication_id) REFERENCES publications(id);


ALTER TABLE shopping_cart_games
    ADD CONSTRAINT FK_shopping_cart_games_game_id
        FOREIGN KEY (game_id) REFERENCES games(id);