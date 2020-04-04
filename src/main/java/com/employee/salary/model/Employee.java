package com.employee.salary.model;

/** Created by Simreen on 28/03/20. */
public class Employee {
  private String name;
  private double annualSalary;

  public Employee(String name, double salary) {
    this.name = name;
    this.annualSalary = salary;
  }

  public double getAnnualSalary() {
    return annualSalary;
  }

  @Override
  public String toString() {
    return "Monthly Payslip for: \"" + name + "\"";
  }
}
