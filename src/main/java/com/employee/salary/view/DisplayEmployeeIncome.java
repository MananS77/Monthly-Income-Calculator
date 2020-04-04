package com.employee.salary.view;

import com.employee.salary.model.Employee;
import com.employee.salary.model.Income;
import com.employee.salary.service.impl.CalculateMonthlyIncomeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Created by Simreen on 29/03/20. */
@Component
public class DisplayEmployeeIncome {

  @Autowired CalculateMonthlyIncomeImpl calculateMonthlyIncome;

  public void display(String[] args) {
    Employee employee = getEmployee(args);
    Income income = getIncome(employee);
    System.out.println(employee);
    System.out.print(income);
  }

  public Employee getEmployee(String[] args) {
    Employee employee = null;
    try {
      employee = new Employee(args[0], Double.parseDouble(args[1]));
    } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
      System.err.println("Please enter both the name and annual salary of the employee");
    } catch (NumberFormatException nfe) {
      System.err.println("Please enter a valid annual salary");
    }
    return employee;
  }

  public Income getIncome(Employee employee) {
    return new Income(calculateMonthlyIncome.fetchVariousIncomes(employee.getAnnualSalary()));
  }
}
