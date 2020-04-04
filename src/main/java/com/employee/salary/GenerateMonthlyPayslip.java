package com.employee.salary;

import com.employee.salary.view.DisplayEmployeeIncome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Created by Simreen on 29/03/20. */
@SpringBootApplication
public class GenerateMonthlyPayslip implements CommandLineRunner {

  @Autowired DisplayEmployeeIncome displayEmployeeIncome;

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(GenerateMonthlyPayslip.class);
    application.run(args);
  }

  @Override
  public void run(String... args) throws Exception {
    displayEmployeeIncome.display(args);
  }
}
