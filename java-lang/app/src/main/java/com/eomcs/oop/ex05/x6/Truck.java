package com.eomcs.oop.ex05.x6;

public class Truck extends Car {

  int weight;

  @Override
  public void run() {
    this.go();
  }

  @Override
  public void start() {
    this.launch();
  }

  @Override
  public void stop() {
    this.stopping();
  }

  public void launch() {
    System.out.println("트럭 시동!");
  }

  public void stopping() {
    System.out.println("트럭 시동 끔!");
  }

  public void go() {
    System.out.println("트럭 덜덜덜 달린다!");
  }

  public void dump() {
    System.out.println("짐 내려!");
  }
}
