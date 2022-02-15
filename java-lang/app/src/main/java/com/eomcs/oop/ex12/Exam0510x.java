// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;


public class Exam0510x {

  static class MyCalculator {
    public static int plus(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
  }

  interface Calculator {
    int compute(int x, int y);
  }

  public static void main(String[] args) {
    // 1) local
    class CalImpl implements Calculator {
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    }
    Calculator c1 = new CalImpl();
    System.out.println(c1.compute(200, 17)); 

    // 2) anonymous
    System.out.println(c2.compute(200, 17)); 

    // 3) lambda
    System.out.println(c3.compute(200, 17));

    // 4) method reference
    System.out.println(c4.compute(200, 17)); 

  }
}


