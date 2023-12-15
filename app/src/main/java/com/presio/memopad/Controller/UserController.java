package com.presio.memopad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.presio.memopad.Model.User;
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
  // public List<UserResponse> getUsers() {
  public List<User> getUsers() {
    List<User> users = userService.getAllUser();
    // List<UserResponse> res = users.stream().map(user -> new
    // UserResponse(user)).toList();
    // return res;
    return users;
  }

  @PostMapping("/signUp")
  // public UserResponse signUp(@RequestBody SignUpRequest input) {
  public User signUp(@RequestBody SignUpRequest input) {
    User user = new User();
    user.setEmail(input.getEmail());
    user.setPassword(input.getPassword());
    // UserResponse res = new UserResponse(userService.createUser(user));
    User res = userService.createUser(user);
    return res;
  }

}
