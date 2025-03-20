package com.ciphergate.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

  final User user;

  public UserPrincipal(User user) {
    this.user = user;
  }


  /**
   * @return collection of granted authorities
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(new SimpleGrantedAuthority("ADMIN"));
  }

  /**
   * @return user password
   */
  @Override
  public String getPassword() {
    return user.getPassword();
  }

  /**
   * @return user username
   */
  @Override
  public String getUsername() {
    return user.getUsername();
  }

  /**
   * @return user account expiration status
   */
  @Override
  public boolean isAccountNonExpired() {
    return UserDetails.super.isAccountNonExpired();
  }

  /**
   * @return user account lock status
   */
  @Override
  public boolean isAccountNonLocked() {
    return UserDetails.super.isAccountNonLocked();
  }

  /**
   * @return user credentials status
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return UserDetails.super.isCredentialsNonExpired();
  }

  /**
   * @return user enabled
   */
  @Override
  public boolean isEnabled() {
    return true;
  }
}
