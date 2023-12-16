package com.presio.memopad.Error;

public class EmailIsNotExistsException extends RuntimeException {
  public EmailIsNotExistsException(String email) {
    super("This email address is not exists: " + email);
  }
}
