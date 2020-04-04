package com.employee.salary.service.impl;

import com.employee.salary.util.IncomeTaxUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/** Created by Simreen on 30/03/20. */
@RunWith(MockitoJUnitRunner.class)
public class CalculateMonthlyIncomeImplTest {

  @InjectMocks private CalculateMonthlyIncomeImpl calculateMonthlyIncome;

  @Spy IncomeTaxUtil incomeTaxUtil;

  private double delta = 0.0;
  private double[] expected_10000 = new double[3];
  private double[] expected_60000 = new double[3];
  private double[] expected_180000 = new double[3];

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    populateIncomeArrays();
  }

  private void populateIncomeArrays() {
    expected_10000[0] = 833;
    expected_10000[1] = 0;
    expected_10000[2] = 833;

    expected_60000[0] = 5000;
    expected_60000[1] = 500;
    expected_60000[2] = 4500;

    expected_180000[0] = 15000;
    expected_180000[1] = 3333;
    expected_180000[2] = 11667;
  }

  @Test
  public void testFetchVariousIncomes_10000() {
    double[] actual = calculateMonthlyIncome.fetchVariousIncomes(10000);
    Assert.assertEquals(expected_10000[0], Math.round(actual[0]), delta);
    Assert.assertEquals(expected_10000[1], Math.round(actual[1]), delta);
    Assert.assertEquals(expected_10000[2], Math.round(actual[2]), delta);
  }

  @Test
  public void testFetchVariousIncomes_60000() {
    double[] actual = calculateMonthlyIncome.fetchVariousIncomes(60000);
    Assert.assertEquals(expected_60000[0], Math.round(actual[0]), delta);
    Assert.assertEquals(expected_60000[1], Math.round(actual[1]), delta);
    Assert.assertEquals(expected_60000[2], Math.round(actual[2]), delta);
  }

  @Test
  public void testFetchVariousIncomes_180000() {
    double[] actual = calculateMonthlyIncome.fetchVariousIncomes(180000);
    Assert.assertEquals(expected_180000[0], Math.round(actual[0]), delta);
    Assert.assertEquals(expected_180000[1], Math.round(actual[1]), delta);
    Assert.assertEquals(expected_180000[2], Math.round(actual[2]), delta);
  }
}
