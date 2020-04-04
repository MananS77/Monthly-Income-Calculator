package com.employee.salary.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Created by Simreen on 30/03/20. */
@RunWith(JUnit4.class)
public class IncomeTaxUtilTest {

  private IncomeTaxUtil incomeTaxUtil = new IncomeTaxUtil();

  private float delta = 0.0f;

  @Test
  public void testGetSlabAndPreviousBound_slab3() {
    int[] expected = new int[2];
    expected[0] = 3;
    expected[1] = 40000;
    int[] actual = incomeTaxUtil.getSlabAndPreviousBound(60000);
    Assert.assertEquals(expected[0], actual[0]);
    Assert.assertEquals(expected[1], actual[1]);
  }

  @Test
  public void testGetSlabAndPreviousBound_slab4() {
    int[] expected = new int[2];
    expected[0] = 4;
    expected[1] = 80000;
    int[] actual = incomeTaxUtil.getSlabAndPreviousBound(180000);
    Assert.assertEquals(expected[0], actual[0]);
    Assert.assertEquals(expected[1], actual[1]);
  }

  @Test
  public void testGetSlabAndPreviousBound_slab4_Negative() {
    int[] expected = new int[2];
    expected[0] = 3;
    expected[1] = 40000;
    int[] actual = incomeTaxUtil.getSlabAndPreviousBound(180000);
    Assert.assertNotEquals(expected[0], actual[0]);
    Assert.assertNotEquals(expected[1], actual[1]);
  }

  @Test
  public void testGetMultiplier_2() {
    float expected = 0.1f;
    float actual = incomeTaxUtil.getTaxMultiplier(2);
    Assert.assertEquals(expected, actual, delta);
  }

  @Test
  public void testGetMultiplier_5() {
    float expected = 0.4f;
    float actual = incomeTaxUtil.getTaxMultiplier(5);
    Assert.assertEquals(expected, actual, delta);
  }

  @Test
  public void testGetMultiplier_5_Negative() {
    float expected = 0.3f;
    float actual = incomeTaxUtil.getTaxMultiplier(5);
    Assert.assertNotEquals(expected, actual, delta);
  }
}
