package com.presio.memopad.intercepter;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.presio.memopad.model.AuthSession;
import com.presio.memopad.model.User;
import com.presio.memopad.repository.AuthSessionRepository;
import com.presio.memopad.service.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthIntercepter implements HandlerInterceptor {

  private final StringRedisTemplate stringRedisTemplate;
  private final UserService userService;
  private final AuthSessionRepository authSessionRepository;

  public AuthIntercepter(StringRedisTemplate stringRedisTemplate, UserService userService,
      AuthSessionRepository authSessionRepository) {
    this.stringRedisTemplate = stringRedisTemplate;
    this.userService = userService;
    this.authSessionRepository = authSessionRepository;
  }

  @PostConstruct
  public void init() {
    stringRedisTemplate.afterPropertiesSet();
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.err.println("preHandle");
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if ("sessionId".equals(cookie.getName())) {
          String sessionId = cookie.getValue();
          String sessinoStr = stringRedisTemplate.opsForValue().get(sessionId);
          if (sessinoStr == null) {
            return false;
          }
          AuthSession authSession = authSessionRepository.fromJson(sessinoStr);
          User user = userService.getUserById(authSession.getUserId());
          request.setAttribute("user", user);
          return true;
        }
      }
    }
    response.sendRedirect("/login");
    return false;
  }
}
