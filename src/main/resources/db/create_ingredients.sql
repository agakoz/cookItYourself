--liquibase formatted sql
--changeset agakoz:1
CREATE TABLE Ingredients
(
    id BIGSERIAL PRIMARY KEY,
    amount VARCHAR(60) ,
    name VARCHAR(100) NOT NULL,
    recipe_id BIGINT NOT NULL

);

ALTER TABLE Ingredients
    ADD CONSTRAINT FK_INGREDIENT_RECIPE
        FOREIGN KEY (recipe_id) REFERENCES RECIPES (id);