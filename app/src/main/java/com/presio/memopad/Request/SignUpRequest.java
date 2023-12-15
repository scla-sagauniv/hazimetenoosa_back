package com.presio.memopad.Request;

import lombok.Data;

@Data
public class SignUpRequest {
  private String email;

  private String password;
}
