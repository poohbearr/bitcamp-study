package com.eomcs.oop.ex05.x7;

public class Truck extends Car {

  int weight;

  public void launch() {
    System.out.println("트럭 시동 건다!");
  }

  public void stopping() {
    System.out.println("트럭 시동 끈다!");
  }

  public void go() {
    System.out.println("트럭 달린다!");
  }

  public void dump() {
    System.out.println("짐 내린다!");
  }

  @Override
  public void start() {
    this.launch();
  }

  @Override
  public void stop() {
    this.stopping();
  }

  @Override
  public void run() {
    this.go();
  }

}
