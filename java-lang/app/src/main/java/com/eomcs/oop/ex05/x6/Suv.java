package com.eomcs.oop.ex05.x6;

public class Suv extends Car {

  boolean enabled4wd;
  boolean active4wd;

  @Override
  public void run() {
    if (enabled4wd) {
      System.out.println("SUV 강력하게 달린다!");
    } else {
      System.out.println("SUV 그냥 달린다!");
    }
  }

  public void active4wd(boolean enable) {
    this.enabled4wd = enable;
  }
}
