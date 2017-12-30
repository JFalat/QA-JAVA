package com.qatraining.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void distance() {
    Point point1 = new Point(1.00, 2.00);
    Point point2 = new Point(3.00, 4.00);

//    positive test
    assert point1.distanceToPoint(point2) == 2.8284271247461903;


//    negative test with ng information
//    Assert.assertEquals(point1.distanceToPoint(point2), 3.8284271247461903);
  }
}
