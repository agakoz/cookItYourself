package com.agakoz.cookItYourself.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class myController {
    @GetMapping("/")
    public String hello(@AuthenticationPrincipal UsernamePasswordAuthenticationToken user) {
        return "Hello";
    }
}
