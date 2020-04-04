package com.employee.salary.service.impl;

import static com.employee.salary.constants.SalaryConstants.NUMBER_OF_MONTHS_IN_YEAR;

import com.employee.salary.service.CalculateIncome;
import com.employee.salary.service.CalculateMonthlyIncome;
import com.employee.salary.util.IncomeTaxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Created by Simreen on 29/03/20. */
@Component
public class CalculateMonthlyIncomeImpl implements CalculateIncome, CalculateMonthlyIncome {

  @Autowired IncomeTaxUtil incomeTaxUtil;

  @Override
  public double[] fetchVariousIncomes(double annualSalary) {
    double[] incomeArray = new double[3];
    incomeArray[0] = calculateGrossMonthlyIncome(annualSalary);
    incomeArray[1] = calculateMonthlyIncomeTax(annualSalary);
    incomeArray[2] = calculateNetMonthlyIncome(incomeArray[0], incomeArray[1]);
    return incomeArray;
  }

  @Override
  public double calculateGrossMonthlyIncome(double annualSalary) {
    return annualSalary / NUMBER_OF_MONTHS_IN_YEAR;
  }

  @Override
  public double calculateMonthlyIncomeTax(double annualSalary) {
    double monthlyIncomeTax = 0;
    int incomeTaxSlab = incomeTaxUtil.getSlabAndPreviousBound(annualSalary)[0];
    double remainingSalary = annualSalary;
    while (incomeTaxSlab >= 0) {
      double taxMultiplier = incomeTaxUtil.getTaxMultiplier(incomeTaxSlab);
      int upperBound = incomeTaxUtil.getSlabAndPreviousBound(remainingSalary)[1];
      double interimTax = taxMultiplier * (remainingSalary - upperBound);
      remainingSalary = upperBound;
      incomeTaxSlab--;
      monthlyIncomeTax += interimTax;
    }

    return monthlyIncomeTax / NUMBER_OF_MONTHS_IN_YEAR;
  }

  @Override
  public double calculateNetMonthlyIncome(double grossMonthlyIncome, double monthlyIncomeTax) {
    return grossMonthlyIncome - monthlyIncomeTax;
  }
}
