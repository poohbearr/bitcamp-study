package com.eomcs.oop.ex05.x7;

public class Sedan extends Car {

  boolean auto;
  boolean openedSunroof;

  @Override
  public void run() {
    System.out.println("세단 달린다!");
  }
}
