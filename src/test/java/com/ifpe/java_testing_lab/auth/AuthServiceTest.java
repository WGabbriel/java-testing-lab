package com.ifpe.java_testing_lab.auth;

import static org.junit.jupiter.api.Assertions.assertSame;
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

import com.ifpe.java_testing_lab.entity.AbstractUser;
import com.ifpe.java_testing_lab.entity.User;
import com.ifpe.java_testing_lab.entity.UserClient;
import com.ifpe.java_testing_lab.entity.UserEmployee;
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

    // when(userRepository.findByEmail(userClient.getEmail())).thenReturn(Optional.empty());

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

  @Test
  void deveRealizarLoginDoUserClientComSucesso() {

    // Arrange
    AbstractUser userClient = createUserClient();
    String userName = userClient.getUserName();
    String password = userClient.getPassword();

    when(userRepository.findByUserName(userName)).thenReturn(Optional.of(userClient));

    // Act
    AbstractUser resultado = authService.login(userName, password);

    // Assert
    verify(userRepository).findByUserName(userName);
    assertSame(userClient, resultado);
  }

  @Test
  void deveRealizarLoginDoUserClientSemUsername() {

    // Arrange
    AbstractUser userClient = createUserClient();
    String userName = null;
    String password = userClient.getPassword();

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.login(userName, password);
    });
  }

  @Test
  void deveRealizarLoginDoUserClientSemSenha() {

    // Arrange
    AbstractUser userClient = createUserClient();
    String userName = userClient.getUserName();
    String password = null;

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.login(userName, password);
    });
  }

  // USUÁRIO COMUM (PRIMEIRO CADASTRO QUE DEVE SER FEITO - TC001 ATÉ TC009 -)

  @Test
  void deveRegistrarUsuarioComumComSucesso() {

    // Arrange
    User user = createUserComumn();

    // Act
    authService.registerUser(user);

    // Assert
    verify(userRepository).saveUser(any(User.class));
  }

    @Test
  void deveFalharCadastroDoUserComumSemCodigo() {
    // Arrange
    User user = createUserComumn();
    user.setUserCode(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerUser(user);
    });
  }

  @Test
  void deveFalharCadastroDoUserComumSemNome() {
    // Arrange
    User user = createUserComumn();
    user.setUserName(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerUser(user);
    });
  }

  @Test
  void deveFalharCadastroDoUserComumSemSenha() {
    // Arrange
    User user = createUserComumn();
    user.setPassword(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerUser(user);
    });
  }

  @Test
  void deveFalharCadastroDoUserComumSemPerfil() {
    // Arrange
    User user = createUserComumn();
    user.setUserProfile(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerUser(user);
    });
  }

  @Test
  void deveFalharCadastroDoUserComumSemEmail() {
    // Arrange
    User user = createUserComumn();
    user.setEmailAddress(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerUser(user);
    });
  }

  @Test
  void deveFalharCadastroDoUserComumSemData() {
    // Arrange
    User user = createUserComumn();
    user.setRegisterDate(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registerUser(user);
    });
  }


  // EMPLOYEES (TC010 ATÉ TC019)

  @Test
  void deveRegistrarFuncionarioComSucesso() {

    // Arrange
    UserEmployee userEmployee = creatUserEmployee();

    // Act
    authService.registUserEmployee(userEmployee);

    // Assert
    verify(userRepository).saveUser(any(UserEmployee.class));
  }

  @Test
  void deveFalharCadastroDoFuncionarioSemCodigoDoFuncionario() {
    // Arrange
    UserEmployee userEmployee = creatUserEmployee();
    userEmployee.setEmployeeCode(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registUserEmployee(userEmployee);
    });
  }

  @Test
  void deveFalharCadastroDoFuncionarioSemAreaDaEmpresaDoFuncionario() {
    // Arrange
    UserEmployee userEmployee = creatUserEmployee();
    userEmployee.setCompanyArea(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registUserEmployee(userEmployee);
    });
  }

  @Test
  void deveFalharCadastroDoFuncionarioSemMatricula() {
    // Arrange
    UserEmployee userEmployee = creatUserEmployee();
    userEmployee.setEnrollment(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registUserEmployee(userEmployee);
    });
  }

  @Test
  void deveFalharCadastroDoFuncionarioSemCodigoDoUser() {
    // Arrange
    UserEmployee userEmployee = creatUserEmployee();
    userEmployee.setUserCode(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registUserEmployee(userEmployee);
    });
  }

  @Test
  void deveFalharCadastroDoFuncionarioSemNomeDoUser() {
    // Arrange
    UserEmployee userEmployee = creatUserEmployee();
    userEmployee.setUserName(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registUserEmployee(userEmployee);
    });
  }

  @Test
  void deveFalharCadastroDoFuncionarioSemSenhaDoUser() {
    // Arrange
    UserEmployee userEmployee = creatUserEmployee();
    userEmployee.setPassword(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registUserEmployee(userEmployee);
    });
  }

  @Test
  void deveFalharCadastroDoFuncionarioSemPerfilDoUser() {
    // Arrange
    UserEmployee userEmployee = creatUserEmployee();
    userEmployee.setUserProfile(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registUserEmployee(userEmployee);
    });
  }

  @Test
  void deveFalharCadastroDoFuncionarioSemEmail() {
    // Arrange
    UserEmployee userEmployee = creatUserEmployee();
    userEmployee.setEmailAddress(null);

    // Assert
    assertThrows(IllegalArgumentException.class, () -> {
      authService.registUserEmployee(userEmployee);
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

  private UserEmployee creatUserEmployee() {
    UserEmployee userEmployee = new UserEmployee();
    userEmployee.setEmployeeCode("1234");
    userEmployee.setCompanyArea("segurança");
    userEmployee.setEnrollment("54321");
    userEmployee.setUserCode(1L);
    userEmployee.setUserName("Guilherme");
    userEmployee.setPassword("12345678@Gui");
    userEmployee.setUserProfile("Funcionário");
    userEmployee.setEmailAddress("gui@gmail.com");
    userEmployee.setRegisterDate("11/02/2026");

    return userEmployee;
  }

  private User createUserComumn() {
    User userComm = new User();
    userComm.setUserCode(1L);
    userComm.setUserName("Paulo");
    userComm.setPassword("123456@pa");
    userComm.setUserProfile("Paciente");
    userComm.setEmailAddress("pa@gmail.com");
    userComm.setRegisterDate("11/11/2024");

    return userComm;
  }
}