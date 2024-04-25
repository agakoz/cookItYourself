package com.agakoz.cookItYourself.service;

import com.agakoz.cookItYourself.model.Comment;
import com.agakoz.cookItYourself.repository.CommentRepository;
import com.agakoz.cookItYourself.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    RecipeService recipeService;
    RecipeRepository recipeRepository;
    CommentRepository commentRepository;

    public Comment addCommentToRecipe(Comment comment, String username) {
        if(!recipeRepository.existsById(comment.getRecipeId())) throw new IllegalArgumentException("Recipe doesnt exist");
        comment.setUsername(username);
        commentRepository.save(comment);
        return comment;
    }

    public Comment editComment(Comment editedComment, String author) {
        Comment comment = commentRepository.findById(editedComment.getId()).orElseThrow();
        if(comment.getUsername() != author) throw new IllegalArgumentException("Comment does not belong to this user");
        comment.setCreated(editedComment.getCreated());
        comment.setContent(editedComment.getContent());
        commentRepository.save(comment);
        return comment;
    }
}
