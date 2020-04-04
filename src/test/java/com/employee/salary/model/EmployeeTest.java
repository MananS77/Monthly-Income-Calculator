package com.employee.salary.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Created by Simreen on 30/03/20. */
@RunWith(JUnit4.class)
public class EmployeeTest {
  private Employee employee_mary;
  private Employee employee_tom;
  private double delta = 0.0;

  @Before
  public void setup() {
    employee_mary = new Employee("Mary Song", 60000);
    employee_tom = new Employee("Tom Hardy", 280000);
  }

  @Test
  public void testGetAnnualSalary_Mary() {
    double expected = 60000;
    double actual = employee_mary.getAnnualSalary();
    Assert.assertEquals(expected, actual, delta);
  }

  @Test
  public void testGetAnnualSalary_Tom() {
    double expected = 280000;
    double actual = employee_tom.getAnnualSalary();
    Assert.assertEquals(expected, actual, delta);
  }

  @Test
  public void testToString_Mary() {
    String expected = "Monthly Payslip for: \"Mary Song\"";
    String actual = employee_mary.toString();
    Assert.assertNotNull(actual);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testToString_Tom() {
    String expected = "Monthly Payslip for: \"Tom Hardy\"";
    String actual = employee_tom.toString();
    Assert.assertNotNull(actual);
    Assert.assertEquals(expected, actual);
  }
}
