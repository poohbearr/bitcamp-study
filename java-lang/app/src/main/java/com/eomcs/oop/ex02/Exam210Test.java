package com.eomcs.oop.ex02;

// 1) 메서드를 클래스에 묶는다
// 2) result를 클래스 변수로 바꾼다
// 3) result를 인스턴스 변수로 바꾼다
// 4) this 내장변수를 사용한다
// 5) 클래스를 외부로 이동
public class Exam210Test {


  public static void main(String[] args) {

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(2);
    c2.plus(5);
    c1.plus(2);
    c2.plus(7);
    c1.minus(1);
    c2.minus(1);
    c1.multiple(7);
    c2.multiple(7);
    c1.divide(3);
    c2.divide(7);

    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);
  }
}

