package com.eomcs.oop.ex05.x1.test5;

public class CalculatorTest {
  public static void main(String[] args) {
    Calculator2 c = new Calculator2();

    c.plus(100);
    c.minus(200);
    c.multiple(2);

    System.out.println(c.getResult());
  }
}






