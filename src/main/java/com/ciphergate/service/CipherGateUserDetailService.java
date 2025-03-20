package com.ciphergate.service;

import com.ciphergate.model.User;
import com.ciphergate.model.UserPrincipal;
import com.ciphergate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CipherGateUserDetailService implements UserDetailsService {

  @Autowired
  private UserRepo userRepo;

  /**
   * @param username from database
   * @return user instance
   * @throws UsernameNotFoundException if user not found in database
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByUsername(username);

    if (user == null) {
      System.out.println("User not found");
      throw new UsernameNotFoundException("User not found" + username);
    }

    return new UserPrincipal(user);
  }
}
