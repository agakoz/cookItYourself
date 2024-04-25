package com.agakoz.cookItYourself.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

@Entity(name = "recipe_images")
@NoArgsConstructor
@AllArgsConstructor
public class RecipeImage {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private byte[] img;
    private String description;
    private int step;
}
