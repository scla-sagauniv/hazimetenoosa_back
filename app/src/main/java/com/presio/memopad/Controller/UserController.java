package com.presio.memopad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.presio.memopad.Error.UserPasswordIsIncorrect;
import com.presio.memopad.Model.User;
import com.presio.memopad.Request.SignInRequest;
import com.presio.memopad.Request.SignUpRequest;
import com.presio.memopad.Response.UserResponse;
import com.presio.memopad.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

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
    return ResponseEntity.ok(res);
    // User res = userService.createUser(user);
  }

  @PostMapping("/signIn")
  public ResponseEntity<UserResponse> signIn(@RequestBody SignInRequest input) {
    User user = userService.getUserByEmail(input.getEmail());
    if (!user.getPassword().equals(input.getPassword())) {
      throw new UserPasswordIsIncorrect(input.getPassword());
    }
    UserResponse res = new UserResponse(user);
    return ResponseEntity.ok(res);
  }

}
