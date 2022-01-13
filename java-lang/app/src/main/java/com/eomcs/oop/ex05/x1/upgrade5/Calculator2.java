package com.eomcs.oop.ex05.x1.upgrade5;

import com.eomcs.oop.ex05.x1.Calculator;

public class Calculator2 {

  // 의존 객체를 외부에서 주입받는다.
  Calculator origin;

  public Calculator2(Calculator origin) {
    this.origin = origin;
  }

  public void plus(int value) {
    origin.plus(value);
  }

  public void minus(int value) {
    origin.minus(value);
  }

  public void multiple(int value) {
    origin.result *= value;
  }

  public int getResult() {
    return origin.result;
  }
}
