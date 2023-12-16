package com.presio.memopad.Error;

public class EmailIsAlreadyUsedException extends RuntimeException {
  public EmailIsAlreadyUsedException(String email) {
    super("This email address is already used: " + email);
  }
}
