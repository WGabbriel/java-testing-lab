package com.ifpe.java_testing_lab.auth;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
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
import com.ifpe.java_testing_lab.service.AuthService;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

  @Mock
  UserRepository userRepository;

  @InjectMocks
  AuthService authService;

  @Test
  public void deveRegistrarUserClientComSucesso() {

    // Arrange
    UserClient userClient = createUserClient();

    //when(userRepository.findByEmail(userClient.getEmail())).thenReturn(Optional.empty());

    // Act
    authService.registerClient(userClient);

    // Assert
    verify(userRepository).saveUser(any(UserClient.class));
  }

  @Test
  public void deveRegistrarClienteComCodigoDeUsuarioAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setUserCode(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

  @Test
  public void deveRegistrarClienteComNomeDeUsuarioAusente() {

    // Arrange
    UserClient userClient3 = createUserClient();
    userClient3.setUserName(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient3);
    });
  }

    @Test
  public void deveRegistrarClienteComSenhaDeUsuarioAusente() {

    // Arrange
    UserClient userClient4 = createUserClient();
    userClient4.setPassword(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient4);
    });
  }

  @Test
  public void deveRegistrarClienteComPerfilDeUsuarioAusente() {

    // Arrange
    UserClient userClient4 = createUserClient();
    userClient4.setUserProfile(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient4);
    });
  }

  private UserClient createUserClient() {
    // Dados recebidos da planilha de casos de teste

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