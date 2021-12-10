package com.eomcs.lang.ex06;

// # 흐름 제어문 - for 중첩과 break
//
public class Exam0433 {
  public static void main(String[] args) {
    // continue
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        if ((j & 1) == 0) // j % 2 == 0 과 같음!
          continue;
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}


