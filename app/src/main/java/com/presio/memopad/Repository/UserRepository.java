package com.presio.memopad.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.presio.memopad.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  List<User> findByEmail(String email);
}
