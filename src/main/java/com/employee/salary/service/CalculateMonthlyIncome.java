package com.employee.salary.service;

/** Created by Simreen on 29/03/20. */
public interface CalculateMonthlyIncome {

  public double calculateGrossMonthlyIncome(double annualSalary);

  public double calculateMonthlyIncomeTax(double annualSalary);

  public double calculateNetMonthlyIncome(double grossMonthlyIncome, double monthlyIncomeTax);
}
