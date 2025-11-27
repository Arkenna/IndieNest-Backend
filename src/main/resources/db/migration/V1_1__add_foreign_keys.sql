ALTER TABLE answers
    ADD CONSTRAINT FK_answers_publication_id FOREIGN KEY (publication_id) REFERENCES publications(id);

ALTER TABLE answers
    ADD CONSTRAINT FK_answers_user_id FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE publications
    ADD CONSTRAINT FK_publications_user_id FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE accounts
    ADD CONSTRAINT FK_accounts_user_id FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE audios
    ADD CONSTRAINT FK_audios_account_id FOREIGN KEY (account_id) REFERENCES accounts(id);

ALTER TABLE arts
    ADD CONSTRAINT FK_arts_account_id FOREIGN KEY (account_id) REFERENCES accounts(id);

ALTER TABLE games
    ADD CONSTRAINT FK_games_account_id FOREIGN KEY (account_id) REFERENCES accounts(id);

ALTER TABLE shopping_carts
    ADD CONSTRAINT FK_shopping_carts_profile_id FOREIGN KEY (profile_id) REFERENCES profiles(id);

ALTER TABLE profiles
    ADD CONSTRAINT FK_profiles_portfolio_id FOREIGN KEY (portfolio_id) REFERENCES portfolios(id);


ALTER TABLE reviews
    ADD CONSTRAINT FK_reviews_user_id FOREIGN KEY (user_id) REFERENCES users(id);




ALTER TABLE shopping_cart_games
    ADD CONSTRAINT FK_shopping_cart_games_game_id
        FOREIGN KEY (game_id) REFERENCES games(id);

ALTER TABLE portfolio_games
    ADD CONSTRAINT FK_portfolio_games_game_id
        FOREIGN KEY (game_id) REFERENCES games(id);

ALTER TABLE portfolio_audios
    ADD CONSTRAINT FK_portfolio_audios_audio_id
        FOREIGN KEY (audio_id) REFERENCES audios(id);

ALTER TABLE portfolio_arts
    ADD CONSTRAINT FK_portfolio_arts_art_id
        FOREIGN KEY (art_id) REFERENCES arts(id);