package com.presio.memopad.response;

import com.presio.memopad.model.User;

public record UserResponse(Integer id, String email, String password) {
  public UserResponse(User user) {
    this(user.getId(), user.getEmail(), user.getPassword());
  }
}
