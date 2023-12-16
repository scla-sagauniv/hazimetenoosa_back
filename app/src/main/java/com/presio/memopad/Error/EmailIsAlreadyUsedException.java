package com.presio.memopad.error;

public class EmailIsAlreadyUsedException extends RuntimeException {
  public EmailIsAlreadyUsedException(String email) {
    super("This email address is already used: " + email);
  }
}
