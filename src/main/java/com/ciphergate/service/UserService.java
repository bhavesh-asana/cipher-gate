package com.ciphergate.service;

import com.ciphergate.model.User;
import com.ciphergate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;
  final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

  public User saveUser(User user){
    user.setPassword(encoder.encode(user.getPassword()));
    return userRepo.save(user);
  }
}
