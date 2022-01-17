package com.eomcs.oop.ex05.x7;

public class CarTest3 {

  public static void main(String[] args) {

    Sedan sedan = new Sedan();
    SnowChain snowChain = new SnowChain(sedan);
    testCar(snowChain);

    System.out.println("-------------------");

    Truck truck = new Truck();
    BlackBox bb = new BlackBox(truck);
    testCar(bb);

    System.out.println("-------------------");

    SUV suv = new SUV();
    suv.active4wd(true);
    SnowChain snowChain2 = new SnowChain(suv);
    BlackBox bb2 = new BlackBox(snowChain2);
    testCar(bb2);
  }

  public static void testCar(Car car) {
    car.start();
    car.run();
    car.stop();
  }

}
