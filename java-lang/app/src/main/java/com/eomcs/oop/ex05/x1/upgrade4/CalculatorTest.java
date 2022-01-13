package com.eomcs.oop.ex05.x1.upgrade4;

// 4) 계산기 기능 확장: 방법4 - 포함 관계를 통한 기능 확장
//  - 곱하기 계산 기능 추가
//  - 기존의 Calculator 객체를 포함한 후 새 기능을 추가하기
//
public class CalculatorTest {
  public static void main(String[] args) {
    Calculator2 c = new Calculator2(); // Calculator 객체를 내장하고 있다. Calculator2와 Calculator의 생명주기가 같다.

    c.plus(100);
    c.minus(200);
    c.multiple(2);

    System.out.println(c.getResult());
  }
}






