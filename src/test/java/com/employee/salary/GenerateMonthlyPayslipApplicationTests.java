package com.employee.salary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/** Created by Simreen on 30/03/20. */
@RunWith(SpringRunner.class)
@SpringBootTest(args = {"Mary Song", "60000"})
public class GenerateMonthlyPayslipApplicationTests {

  @Autowired private ApplicationContext applicationContext;

  @Test
  public void testMain() throws Exception {
    CommandLineRunner runner = applicationContext.getBean(CommandLineRunner.class);
    runner.run("Mary Song", "60000");
  }
}
