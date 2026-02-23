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
  public void deveRegistrarUsuarioComCodigoDeUsuarioAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setUserCode(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

  @Test
  public void deveRegistrarUsuarioComNomeDeUsuarioAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setUserName(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

    @Test
  public void deveRegistrarUsuarioComSenhaDeUsuarioAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setPassword(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

  @Test
  public void deveRegistrarUsuarioComEmailDeUsuarioAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setUserProfile(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

  @Test
  public void deveRegistrarUsuarioComEnderecoDeEmailAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setEmailAddress(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

  @Test
  public void deveRegistrarUsuarioComDataDeCadastroAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setRegisterDate(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

  @Test
  public void deveRegistrarClienteComCodigoDoClienteAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setClientCode(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

  @Test
  public void deveRegistrarClienteComNomeDoClienteAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setClientName(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

  @Test
  public void deveRegistrarClienteComDataDeNascimentoAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setBirthDate(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

  @Test
  void deveRegistrarClienteComCPFAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setCpf(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
    });
  }

  @Test
  void deveRegistrarClienteComEmailAusente() {

    // Arrange
    UserClient userClient = createUserClient();
    userClient.setEmail(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerClient(userClient);
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