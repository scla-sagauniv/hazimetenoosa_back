package com.presio.memopad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.presio.memopad.error.UserPasswordIsIncorrectException;
import com.presio.memopad.model.AuthSession;
import com.presio.memopad.model.User;
import com.presio.memopad.request.SignUpRequest;
import com.presio.memopad.response.UserResponse;
import com.presio.memopad.request.SignInRequest;
import com.presio.memopad.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  ObjectMapper mapper = new ObjectMapper();

  @GetMapping("/user")
  public List<UserResponse> getUsers() {
    // public List<User> getUsers() {
    List<User> users = userService.getAllUser();
    List<UserResponse> res = users.stream().map(user -> new UserResponse(user)).toList();
    return res;
    // return users;
  }

  @PostMapping("/signUp")
  public ResponseEntity<UserResponse> signUp(@RequestBody SignUpRequest input) {
    // public User signUp(@RequestBody SignUpRequest input) {
    User user = new User();
    user.setEmail(input.getEmail());
    user.setPassword(input.getPassword());
    UserResponse res = new UserResponse(userService.createUser(user));

    AuthSession session = new AuthSession(user.getId());
    try {
      stringRedisTemplate.opsForValue().set(session.getSessionId(), mapper.writeValueAsString(session));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return ResponseEntity.ok(res);
    // User res = userService.createUser(user);
  }

  @PostMapping("/signIn")
  public ResponseEntity<UserResponse> signIn(@RequestBody SignInRequest input) {
    User user = userService.getUserByEmail(input.getEmail());
    if (!user.getPassword().equals(input.getPassword())) {
      throw new UserPasswordIsIncorrectException(input.getPassword());
    }
    UserResponse res = new UserResponse(user);

    AuthSession session = new AuthSession(user.getId());
    try {
      stringRedisTemplate.opsForValue().set(session.getSessionId(), mapper.writeValueAsString(session));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return ResponseEntity.ok(res);
  }

}
