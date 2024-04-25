package com.agakoz.cookItYourself.controller;

import com.agakoz.cookItYourself.model.Comment;
import com.agakoz.cookItYourself.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CommentsController {

    CommentService commentService;
    @PostMapping("/recipes/comments")
    public Comment addCommentToRecipe(@RequestBody Comment comment, UsernamePasswordAuthenticationToken user) {
        return commentService.addCommentToRecipe(comment, (String)user.getPrincipal());
    }

    @PutMapping("/recipes/comments")
    public Comment editComment(@RequestBody Comment comment, UsernamePasswordAuthenticationToken user) {
        return commentService.editComment(comment, (String)user.getPrincipal());
    }
}
