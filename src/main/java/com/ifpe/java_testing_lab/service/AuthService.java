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

    requireNonBlank(client.getEmailAddress() != null ? client.getEmailAddress() : null,
        "O campo de email do usuário não foi preenchido");

    requireNonBlank(client.getRegisterDate() != null ? client.getRegisterDate() : null,
        "O campo de data de cadastro não foi preenchido");

    requireNonBlank(client.getClientCode() != null ? client.getClientCode().toString() : null,
        "O campo de Código do cliente não foi preenchido");

    requireNonBlank(client.getClientName() != null ? client.getClientName() : null,
        "O campo de Nome do Cliente não foi preenchido");

    requireNonBlank(client.getBirthDate() != null ? client.getBirthDate().toString() : null,
        "O campo de Data de nacimento do Cliente não foi preenchido");

    requireNonBlank(client.getCpf() != null ? client.getCpf() : null,
        "O campo de CPF do Cliente não foi preenchido");

    requireNonBlank(client.getEmail() != null ? client.getEmail() : null,
        "O campo de Email do Cliente não foi preenchido");

    Optional<AbstractUser> existing = userRepository.findByEmail(client.getEmailAddress());
    if (existing.isPresent()) {
      throw new IllegalStateException("Já existe um usuário cadastrado com este e-mail");
    }

    userRepository.saveUser(client);
    return client;
  }

  public AbstractUser login(String userName, String password) {

    if (userName == null || userName.isBlank()) {
      throw new IllegalArgumentException("O campo de nome do usuário não foi preenchido");
    }
    if (password == null || password.isBlank()) {
      throw new IllegalArgumentException("O campo de senha do usuário não foi preenchido");
    }
    Optional<AbstractUser> result = userRepository.findByUserName(userName);

    if (result.isPresent() && result.get().getPassword().equals(password)) {
      return result.get();
    } else {
      throw new IllegalArgumentException("Nome de usuário ou senha inválidos");
    }
  }

}