package com.agakoz.cookItYourself.repository;

import com.agakoz.cookItYourself.DTO.RecipeOverviewDto;
import com.agakoz.cookItYourself.model.Recipe;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("select new com.agakoz.cookItYourself.DTO.RecipeOverviewDto(id, title) from recipes where username= :username")
    List<RecipeOverviewDto> findRecipesFromUser(@Param("username") String username, PageRequest page);

    @Query("select r from recipes r left join fetch ingredients i where r.id = :id")
    Optional<Recipe> findById(@Param("id") long id);


}
