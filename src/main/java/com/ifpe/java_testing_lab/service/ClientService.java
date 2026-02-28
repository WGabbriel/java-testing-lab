package com.ifpe.java_testing_lab.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.java_testing_lab.entity.AbstractUser;
import com.ifpe.java_testing_lab.entity.UserClient;
import com.ifpe.java_testing_lab.repository.UserRepository;

@Service
public class ClientService {

  @Autowired
  private UserRepository userRepository;

  public UserClient verifyCpf(String cpf) {
    Optional<AbstractUser> result = userRepository.findByCpf(cpf);
    return (UserClient) result.get();
  }

}
