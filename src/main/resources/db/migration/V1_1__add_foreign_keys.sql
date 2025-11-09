ALTER TABLE answers
    ADD CONSTRAINT FK_answers_publication_id FOREIGN KEY (publication_id) REFERENCES publications(id);