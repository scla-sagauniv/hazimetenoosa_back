package com.presio.memopad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.presio.memopad.intercepter.AuthIntercepter;
import com.presio.memopad.repository.AuthSessionRepository;
import com.presio.memopad.service.UserService;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Autowired
  private UserService userService;

  @Autowired
  private AuthSessionRepository authSessionRepository;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new AuthIntercepter(stringRedisTemplate, userService, authSessionRepository))
        .excludePathPatterns("/auth/**");
  }
}
