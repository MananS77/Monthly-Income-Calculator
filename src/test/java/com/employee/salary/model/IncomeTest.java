package com.employee.salary.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Created by Simreen on 30/03/20. */
@RunWith(JUnit4.class)
public class IncomeTest {
  private Income income_mary;
  private Income income_tom;

  @Before
  public void setup() {
    populateIncomeArrays();
  }

  private void populateIncomeArrays() {
    double[] income_array_mary = new double[3];
    income_array_mary[0] = 5000;
    income_array_mary[1] = 500;
    income_array_mary[2] = 4500;
    income_mary = new Income(income_array_mary);

    double[] income_array_tom = new double[3];
    income_array_tom[0] = 2000;
    income_array_tom[1] = 0;
    income_array_tom[2] = 2000;
    income_tom = new Income(income_array_tom);
  }

  @Test
  public void testIncome_Mary() {
    String expected =
        "Gross Monthly Income: $"
            + 5000
            + "\nMonthly Income Tax: $"
            + 500
            + "\nNet Monthly Income: $"
            + 4500;
    String actual = income_mary.toString();
    Assert.assertNotNull(actual);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testIncome_Tom() {
    String expected =
        "Gross Monthly Income: $"
            + 2000
            + "\nMonthly Income Tax: $"
            + 0
            + "\nNet Monthly Income: $"
            + 2000;
    String actual = income_tom.toString();
    Assert.assertNotNull(actual);
    Assert.assertEquals(expected, actual);
  }
}
