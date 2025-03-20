package com.ciphergate.controller;

import com.ciphergate.model.User;
import com.ciphergate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cipher-gate")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public User register(@RequestBody User user){
    return userService.saveUser(user);
  }
}
