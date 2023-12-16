package com.presio.memopad.service;

import org.springframework.http.ResponseCookie;

import com.presio.memopad.model.AuthSession;

import jakarta.servlet.http.HttpServletResponse;

public class CookieService {

  public void setAuthSessionCookie(AuthSession session, HttpServletResponse response) {
    ResponseCookie cookie = ResponseCookie.from("sessionId", session.getSessionId())
        .httpOnly(true)
        .secure(true)
        .path("/")
        .maxAge(4 * 24 * 60 * 60 * 60)
        .domain("")
        .sameSite("None")
        .build();

    response.addHeader("Set-Cookie", cookie.toString());
  }
}
