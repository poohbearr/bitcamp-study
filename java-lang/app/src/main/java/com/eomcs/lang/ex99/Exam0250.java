package com.eomcs.lang.ex99;

//# 키보드 입력 받기 - 여러 개의 데이터를 한 번에 입력하고 쪼개서 읽기
//
public class Exam0250 {
  public static void main(String[] args) { 
    java.util.Scanner keyScan = new java.util.Scanner(System.in);
    
    System.out.println("나이? 이름? 취업여부? ");
    int age = keyScan.nextInt();
    String name = keyScan.next();
    boolean job = keyScan.nextBoolean();
  }
}















