package com.agakoz.cookItYourself.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "recipes")
@NoArgsConstructor
@Getter
@Setter
public class Recipe {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String title;
    private String content;
    @Column(name = "prep_time")
    @JsonFormat(pattern="HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalTime prepTime;

    @Column(name = "cook_time")
    @JsonFormat(pattern="HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalTime cookTime;

    private int kcal;
    @Column(name = "portions_num")
    private int portionsNum;

    private LocalDateTime created;
    private String username;

    @OneToMany(cascade = REMOVE)
    @JoinColumn(name = "recipeId", updatable = false, insertable = false)
    private List<Ingredient> ingredients;

    @OneToMany(cascade = REMOVE)
    @JoinColumn(name = "recipeId", updatable = false, insertable = false)
    private List<Comment> comments;

    @OneToMany(cascade = REMOVE)
    @JoinColumn(name = "recipeId", updatable = false, insertable = false)
    private List<RecipeImage> images;
}
