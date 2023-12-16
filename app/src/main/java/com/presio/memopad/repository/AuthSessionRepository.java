package com.presio.memopad.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.presio.memopad.model.AuthSession;

public class AuthSessionRepository {
  private ObjectMapper mapper = new ObjectMapper();

  public AuthSession fromJson(String json) {
    try {
      AuthSession authSession = mapper.readValue(json, AuthSession.class);
      return authSession;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
