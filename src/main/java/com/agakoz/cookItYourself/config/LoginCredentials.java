package com.agakoz.cookItYourself.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginCredentials {
    private String username;
    private String password;
}
