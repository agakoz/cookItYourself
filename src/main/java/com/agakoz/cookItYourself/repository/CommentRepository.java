package com.agakoz.cookItYourself.repository;

import com.agakoz.cookItYourself.model.Comment;
import com.agakoz.cookItYourself.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRecipeId(long recipeId);
//    @Query("select c from recipes r left join fetch comments c where r.id = :id")
//    Optional<Recipe> getComments(@Param("id") long id);
}
