--liquibase formatted sql
--changeset agakoz:1
ALTER TABLE recipes
    ALTER COLUMN content TYPE varchar(10000);