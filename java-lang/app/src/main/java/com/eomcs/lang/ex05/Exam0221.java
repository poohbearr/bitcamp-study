// 관계 연산자 : 부동소수점 비교 
package com.eomcs.lang.ex05;

public class Exam0221 {
  public static void main(String[] args) {
    float f1 = 0.1f;
    float f2 = 0.1f;

    System.out.println(f1 * f2 == 0.01f); // false

    // 이유?
    System.out.println(f1 * f2); // 0.010000001 결과 값 뒤에 0.000000001 오차 발생!


  }
}
