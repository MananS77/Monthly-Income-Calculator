package com.employee.salary.util;

import org.springframework.stereotype.Component;

/** Created by Simreen on 29/03/20. */
@Component
public class IncomeTaxUtil {

  public int[] getSlabAndPreviousBound(double remainingSalary) {
    int[] slabAndBound = new int[2];

    if (remainingSalary >= 180001) {
      slabAndBound[0] = 5;
      slabAndBound[1] = 180000;
    } else if (remainingSalary >= 80001 && remainingSalary <= 180000) {
      slabAndBound[0] = 4;
      slabAndBound[1] = 80000;
    } else if (remainingSalary >= 40001 && remainingSalary <= 80000) {
      slabAndBound[0] = 3;
      slabAndBound[1] = 40000;
    } else if (remainingSalary >= 20001 && remainingSalary <= 40000) {
      slabAndBound[0] = 2;
      slabAndBound[1] = 20000;
    } else if (remainingSalary >= 0 && remainingSalary <= 20000) {
      slabAndBound[0] = 1;
      slabAndBound[1] = 0;
    }
    return slabAndBound;
  }

  public float getTaxMultiplier(int incomeTaxSlab) {
    switch (incomeTaxSlab) {
      case 1:
        return 0.0f;
      case 2:
        return 0.1f;
      case 3:
        return 0.2f;
      case 4:
        return 0.3f;
      case 5:
        return 0.4f;
      default:
        return 0.0f;
    }
  }
}
