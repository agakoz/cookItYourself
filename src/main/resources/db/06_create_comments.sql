--liquibase formatted sql
--changeset agakoz:2
CREATE TABLE comments (
    id BIGSERIAL PRIMARY KEY,
    content VARCHAR(500),
    username VARCHAR(50) NOT NULL,
    recipe_id BIGINT NOT NULL,
    created TIMESTAMP
);

ALTER TABLE comments
    ADD CONSTRAINT FK_COMMENTS_RECIPE
        FOREIGN KEY (recipe_id) REFERENCES recipes(id);

ALTER TABLE comments
    ADD CONSTRAINT FK_COMMENTS_USER
        FOREIGN KEY (username) REFERENCES users(username);