package com.eomcs.lang.ex06;

// # 흐름 제어문 - for 중첩과 break
//
public class Exam0432 {
  public static void main(String[] args) {
    // break 라벨명;
    loop1:{
      for (int i = 1; i <= 10; i++) {
        for (int j = 1; j <=i; j++) {
          System.out.print(j + " ");
          if (j == 5)
            break loop1; // 루프를 빠져나가기 때문에
        }
        System.out.println();
      }
      System.out.println("\n-----"); // 루프 안에 있을 경우 출력X
    }
  }
}


