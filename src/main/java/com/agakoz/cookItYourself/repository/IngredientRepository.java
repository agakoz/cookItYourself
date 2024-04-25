package com.agakoz.cookItYourself.repository;

import com.agakoz.cookItYourself.model.Ingredient;
import com.agakoz.cookItYourself.model.Recipe;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
