package com.employee.salary.model;

/** Created by Simreen on 28/03/20. */
public class Income {
  private double grossMonthlyIncome;
  private double grossMonthlyIncomeTax;
  private double netMonthlyIncome;

  public Income(double[] incomes) {
    this.grossMonthlyIncome = incomes[0];
    this.grossMonthlyIncomeTax = incomes[1];
    this.netMonthlyIncome = incomes[2];
  }

  @Override
  public String toString() {
    return "Gross Monthly Income: $"
        + Math.round(grossMonthlyIncome)
        + "\nMonthly Income Tax: $"
        + Math.round(grossMonthlyIncomeTax)
        + "\nNet Monthly Income: $"
        + Math.round(netMonthlyIncome);
  }
}
