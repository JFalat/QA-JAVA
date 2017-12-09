package com.qatraining.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    //  System.out.println("Hello, World");

    Point point1 = new Point(2.37, 3.52);
    Point point2 = new Point(5.89, 9.86);
    


    System.out.println("Distance from static function: " + distance(point1, point2));
    System.out.println("Distance from distanceToPoint method: " + point1.distanceToPoint(point2));
  }

  public static double distance(Point p1, Point p2) {
    double distance = Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    return distance;
  }

}
