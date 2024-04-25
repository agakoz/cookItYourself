package com.agakoz.cookItYourself.repository;

import com.agakoz.cookItYourself.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
