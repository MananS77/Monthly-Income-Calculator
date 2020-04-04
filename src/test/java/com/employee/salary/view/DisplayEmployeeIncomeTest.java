package com.employee.salary.view;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import com.employee.salary.service.impl.CalculateMonthlyIncomeImpl;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/** Created by Simreen on 30/03/20. */
@RunWith(MockitoJUnitRunner.class)
public class DisplayEmployeeIncomeTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  @InjectMocks DisplayEmployeeIncome displayEmployeeIncome;
  @Mock CalculateMonthlyIncomeImpl calculateMonthlyIncome;
  private String[] args_Mary_60k;
  private String[] args_Mary_null;
  private String[] args_Mary_nfe;

  private double[] income_array_mary;

  @Before
  public void setup() {
    System.setOut(new PrintStream(outContent));
    populateIncomeAndInputArrays();
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  private void populateIncomeAndInputArrays() {
    income_array_mary = new double[3];
    income_array_mary[0] = 5000;
    income_array_mary[1] = 500;
    income_array_mary[2] = 4500;

    args_Mary_60k = new String[] {"Mary Song", "60000"};
    args_Mary_null = new String[] {"Mary Song", null};
    args_Mary_nfe = new String[] {"Mary Song", "abc"};
  }

  @Test
  public void testDisplay_Mary() {
    String expected =
        "Monthly Payslip for: \"Mary Song\""
            + "\nGross Monthly Income: $5000"
            + "\nMonthly Income Tax: $500"
            + "\nNet Monthly Income: $4500";
    when(calculateMonthlyIncome.fetchVariousIncomes(anyDouble())).thenReturn(income_array_mary);
    displayEmployeeIncome.display(args_Mary_60k);
    Assert.assertEquals(expected, outContent.toString());
  }

  @Test(expected = NullPointerException.class)
  public void testDisplay_NPE_Mary() {
    String expected = "Please enter both the name and annual salary of the employee";
    displayEmployeeIncome.display(args_Mary_null);
    Assert.assertEquals(expected, outContent.toString());
  }

  @Test(expected = NullPointerException.class)
  public void testDisplay_NFE_Mary() {
    String expected = "Please enter a valid annual salary";
    displayEmployeeIncome.display(args_Mary_nfe);
    Assert.assertEquals(expected, outContent.toString());
  }
}
