package com.eomcs.oop.ex02;

public class Exam110Test {

  static class Score {

    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    public void calculator() {
      this.sum = this.kor + this.eng + this.math;
      this.average = this.sum / 3f;
    }

  }

  public static void main(String[] args) {

    Score score = new Score();

    score.name = "홍길동";
    score.kor = 100;
    score.eng = 90;
    score.math = 85;

    score.calculator();

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", score.name, score.kor, score.eng, score.math,
        score.sum, score.average);
  }
}


