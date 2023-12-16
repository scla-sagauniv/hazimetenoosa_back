package com.presio.memopad.Error;

public class EmailIsNotExists extends RuntimeException {
  public EmailIsNotExists(String email) {
    super("This email address is not exists: " + email);
  }
}
