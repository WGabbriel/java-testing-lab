package com.ifpe.java_testing_lab.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ifpe.java_testing_lab.entity.UserClient;
import com.ifpe.java_testing_lab.repository.UserRepository;
import com.ifpe.java_testing_lab.service.ClientService;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

  @Mock
  UserRepository userRepository;

  @InjectMocks
  ClientService clientService;

  @Test
  public void deveVerificarCpfComSucesso() {

    // Arrange
    UserClient userClient = createUserClient();
    String cpf = userClient.getCpf();

    when(userRepository.findByCpf(cpf)).thenReturn(Optional.of(userClient));

    // Act
    UserClient resultado = clientService.verifyCpf(cpf);

    // Assert
    assertEquals(cpf, resultado.getCpf());
  }

  @Test
  public void deveAtualizarPerfilComTodosOsCamposPreenchidos() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setEmail("joaozin@email.com");

    // Act
    UserClient resultado = clientService.updateProfile(userClient);

    // Assert
    assertSame(userClient, resultado);
  }

  private UserClient createUserClient() {
    UserClient userClient = new UserClient();
    userClient.setUserCode(1L);
    userClient.setUserName("Joao");
    userClient.setPassword("Joao123");
    userClient.setUserProfile("Joao");
    userClient.setEmailAddress("Joao@email.com");
    userClient.setRegisterDate(LocalDateTime.now().toString());
    userClient.setClientCode(1L);
    userClient.setClientName("Joao");
    userClient.setBirthDate(LocalDateTime.of(1970, 1, 1, 0, 0));
    userClient.setCpf("12345678900");
    userClient.setEmail("Joao@email.com");

    return userClient;
  }
}
