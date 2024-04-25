--liquibase formatted sql
--changeset agakoz:1
CREATE TABLE recipe_images (
    id BIGSERIAL primary key,
    step INT,
    description varchar(1000),
    img bytea,
    recipe_id BIGINT NOT NULL
);

alter table recipe_images
    add constraint FK_IMAGE_RECIPE
        foreign key (recipe_id) references recipes (id);
