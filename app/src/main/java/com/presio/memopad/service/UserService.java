package com.presio.memopad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presio.memopad.Error.EmailIsAlreadyUsedException;
import com.presio.memopad.Model.User;
import com.presio.memopad.Repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  public User getUserByEmail(String email) {
    List<User> res = userRepository.findByEmail(email);
    if (res.size() == 0) {
      throw new EmailIsAlreadyUsedException(email);
    }
    return res.get(0);
  }

  public User createUser(User user) {
    if (userRepository.findByEmail(user.getEmail()).size() > 0) {
      throw new EmailIsAlreadyUsedException(user.getEmail());
    }
    return userRepository.save(user);
  }
}
