package com.eomcs.lang.ex99;

//# 키보드 입력 받기 - 토큰 단위로 문자열 읽기
//
public class Exam0260 {
  public static void main(String[] args) { 
    java.util.Scanner keyScan = new java.util.Scanner(System.in);


    // next()
    // - 토큰 단위로 입력 데이터를 잘라서 읽을 때 유용하다. 
    System.out.print("입력: ");
    String token1 = keyScan.next();
    String token2 = keyScan.next();
    String token3 = keyScan.next();

    keyScan.close();

    System.out.printf("%s , %s , %s ",token1, token2, token3);


  }
}

