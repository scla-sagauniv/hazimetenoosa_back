package com.presio.memopad.Error;

public class UserPasswordIsIncorrect extends RuntimeException {
  public UserPasswordIsIncorrect(String password) {
    super("This password is incorrect: " + password);
  }
}
