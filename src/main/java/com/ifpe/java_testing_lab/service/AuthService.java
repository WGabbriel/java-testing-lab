package com.ifpe.java_testing_lab.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.java_testing_lab.entity.AbstractUser;
import com.ifpe.java_testing_lab.entity.UserClient;
import com.ifpe.java_testing_lab.repository.UserRepository;

@Service
public class AuthService {

  @Autowired
  private UserRepository userRepository;

  private void requireNonBlank(String value, String message) {
    if (value == null || value.isBlank()) {
      throw new IllegalArgumentException(message);
    }
  }

  // ── Cadastro de UserClient ──────────────────────────────────────────

  public UserClient registerClient(UserClient client) {
    requireNonBlank(client.getUserCode() != null ? client.getUserCode().toString() : null,
        "Código de usuário é obrigatório");

    requireNonBlank(client.getUserName() != null ? client.getUserName() : null,
        "O campo de Nome não foi preenchido");

    requireNonBlank(client.getPassword() != null ? client.getPassword() : null,
        "O campo de senha não foi preenchido");

    requireNonBlank(client.getUserProfile() != null ? client.getUserProfile() : null,
        "O campo de perfil do usuário não foi preenchido");

    Optional<AbstractUser> existing = userRepository.findByEmail(client.getEmailAddress());
    if (existing.isPresent()) {
      throw new IllegalStateException("Já existe um usuário cadastrado com este e-mail");
    }

    userRepository.saveUser(client);
    return client;
  }

}