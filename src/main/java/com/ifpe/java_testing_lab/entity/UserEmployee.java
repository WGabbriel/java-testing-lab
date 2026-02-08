package com.ifpe.java_testing_lab.entity;

public class UserEmployee extends AbstractUser {

  private String employeeCode;
  private String companyArea;
  private String enrollment;

  public String getEmployeeCode() {
    return employeeCode;
  }

  public void setEmployeeCode(String employeeCode) {
    this.employeeCode = employeeCode;
  }

  public String getCompanyArea() {
    return companyArea;
  }

  public void setCompanyArea(String companyArea) {
    this.companyArea = companyArea;
  }

  public String getEnrollment() {
    return enrollment;
  }

  public void setEnrollment(String enrollment) {
    this.enrollment = enrollment;
  }

}
