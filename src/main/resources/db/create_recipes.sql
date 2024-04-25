--liquibase formatted sql
--changeset agakoz:1
CREATE TABLE Recipes (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255),
    prep_time TIME,
    cook_time TIME,
    kcal INT,
    portions_num INT,
    created TIMESTAMP,
    username VARCHAR(50) NOT NULL
);

ALTER TABLE Recipes
    ADD CONSTRAINT FK_RECIPE_USER
        FOREIGN KEY (username) REFERENCES USERS (username);