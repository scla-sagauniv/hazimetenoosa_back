package com.presio.memopad.error;

public class UserPasswordIsIncorrectException extends RuntimeException {
  public UserPasswordIsIncorrectException(String password) {
    super("This password is incorrect: " + password);
  }
}
