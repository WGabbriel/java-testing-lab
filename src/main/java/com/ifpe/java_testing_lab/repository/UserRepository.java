package com.ifpe.java_testing_lab.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ifpe.java_testing_lab.entity.AbstractUser;

@Repository
public interface UserRepository {

  void saveUser(AbstractUser user);

  Optional<AbstractUser> findByEmail(String email);

}