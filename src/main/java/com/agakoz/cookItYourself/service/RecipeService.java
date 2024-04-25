package com.agakoz.cookItYourself.service;

import com.agakoz.cookItYourself.DTO.RecipeOverviewDto;
import com.agakoz.cookItYourself.model.Comment;
import com.agakoz.cookItYourself.model.Ingredient;
import com.agakoz.cookItYourself.model.Recipe;
import com.agakoz.cookItYourself.repository.CommentRepository;
import com.agakoz.cookItYourself.repository.IngredientRepository;
import com.agakoz.cookItYourself.repository.RecipeRepository;
import com.agakoz.cookItYourself.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private RecipeRepository recipeRepository;
    private UserRepository userRepository;
    private IngredientRepository ingredientRepository;
    private CommentRepository commentRepository;
    private final int PAGE_SIZE = 10;

    public List<RecipeOverviewDto> getRecipesByUsername(String username, Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return recipeRepository.findRecipesFromUser(username, PageRequest.of(pageNumber, PAGE_SIZE)) ;
    }

    public List<RecipeOverviewDto> getRecipesFromOtherUser(String username, Integer page) {
        if(!userRepository.existsById(username)) throw new IllegalArgumentException("No such user");
        return getRecipesByUsername(username, page);
    }

    @Transactional
    public Recipe addRecipe(Recipe newRecipe, String username) {
        newRecipe.setUsername(username);
        List<Ingredient> ingredients = newRecipe.getIngredients();
        newRecipe.setIngredients(null);
        recipeRepository.save(newRecipe);
        ingredients.forEach(ingredient -> ingredient.setRecipeId(newRecipe.getId()));
        ingredientRepository.saveAll(ingredients);
        return newRecipe;
    }

    public Recipe getRecipesById(long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow();
        recipe.setComments(commentRepository.findByRecipeId(recipeId));
       return recipe;
    }

    public Recipe updateRecipe(Recipe editedRecipe, String username) throws IllegalAccessException {
        Recipe recipe = recipeRepository.findById(editedRecipe.getId()).orElseThrow();
        if(!recipe.getUsername().equals(username)) throw new IllegalAccessException("Recipe does not belong ot user");
        recipe.setIngredients(editedRecipe.getIngredients());
        recipe.setContent(editedRecipe.getContent());
        recipe.setKcal(editedRecipe.getKcal());
        recipe.setTitle(editedRecipe.getTitle());
        recipe.setCookTime(editedRecipe.getCookTime());
        recipe.setPortionsNum(editedRecipe.getPortionsNum());
        recipe.setCookTime(editedRecipe.getCookTime());
        recipe.setPrepTime(editedRecipe.getPrepTime());
        recipeRepository.save(recipe);
        return recipe;
    }


}
