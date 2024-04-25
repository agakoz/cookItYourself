package com.agakoz.cookItYourself.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.REMOVE;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String username;
    private String password;
    private boolean enabled;

    @OneToMany(cascade = REMOVE)
    @JoinColumn(name = "username", updatable = false, insertable = false)
    private List<Recipe> recipes;

}
