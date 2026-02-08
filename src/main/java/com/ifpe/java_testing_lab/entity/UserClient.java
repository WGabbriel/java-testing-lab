package com.ifpe.java_testing_lab.entity;

import java.time.LocalDateTime;

public class UserClient extends AbstractUser {

  private Long clientCode;
  private String clientName;
  private LocalDateTime birthDate;
  private String cpf;
  private String email;

  public Long getClientCode() {
    return clientCode;
  }

  public void setClientCode(Long clientCode) {
    this.clientCode = clientCode;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
