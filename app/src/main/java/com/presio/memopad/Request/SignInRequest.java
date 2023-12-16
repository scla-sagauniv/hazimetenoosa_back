package com.presio.memopad.Request;

import lombok.Data;

@Data
public class SignInRequest {
  private String email;

  private String password;
}
