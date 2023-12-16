package com.presio.memopad.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class AuthSession {
  @JsonProperty("sessionId")
  @GeneratedValue(strategy = GenerationType.UUID)
  private String sessionId;

  @JsonProperty("userId")
  private Integer userId;

  public AuthSession(Integer userId) {
    this.sessionId = UUID.randomUUID().toString();
    this.userId = userId;
  }
}
