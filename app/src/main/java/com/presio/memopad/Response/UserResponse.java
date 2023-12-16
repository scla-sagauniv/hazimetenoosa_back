package com.presio.memopad.Response;

import com.presio.memopad.Model.User;

public record UserResponse(Integer id, String email, String password) {
  public UserResponse(User user) {
    this(user.getId(), user.getEmail(), user.getPassword());
  }
}
