ALTER TABLE answers
    ADD CONSTRAINT FK_answers_publication_id FOREIGN KEY (publicationId) REFERENCES publications(id);