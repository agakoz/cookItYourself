package com.agakoz.cookItYourself.controller;

import com.agakoz.cookItYourself.DTO.RecipeOverviewDto;
import com.agakoz.cookItYourself.model.Recipe;
import com.agakoz.cookItYourself.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RecipeController {

    private RecipeService recipeService;

    @GetMapping("/myRecipes")
    public List<RecipeOverviewDto> getRecipeFromLoggedUser(@RequestParam(required = false) Integer page, UsernamePasswordAuthenticationToken user) {
        return recipeService.getRecipesByUsername((String)user.getPrincipal(), page);
    }

    @GetMapping("/recipes/user/{username}")
    public List<RecipeOverviewDto> getRecipeFromOtherUser(@RequestParam(required = false) Integer page, @PathVariable("username")String username) {
        return recipeService.getRecipesFromOtherUser(username, page);
    }

    @PostMapping("/myRecipes")
    public Recipe addRecipe(@RequestBody Recipe newRecipe, UsernamePasswordAuthenticationToken user) {
        return recipeService.addRecipe(newRecipe, (String)user.getPrincipal());
    }

    @PutMapping("/myRecipes")
    public Recipe updateRecipe(@RequestBody Recipe recipe, UsernamePasswordAuthenticationToken user) throws IllegalAccessException {
        return recipeService.updateRecipe(recipe, (String)user.getPrincipal());
    }

    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipeById(@PathVariable long recipeId) {
        return recipeService.getRecipesById(recipeId);
    }




}
