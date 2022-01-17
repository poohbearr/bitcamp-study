package com.eomcs.oop.ex05.x7;

public class CarTest1 {

  public static void main(String[] args) {

    Sedan sedan = new Sedan();
    sedan.start();
    sedan.run();
    sedan.stop();

    System.out.println("-------------------");

    Truck truck = new Truck();
    truck.launch();
    truck.go();
    truck.stopping();
  }

}
