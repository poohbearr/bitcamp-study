package com.eomcs.oop.ex05.x7;

public class BlackBox extends Option {

  public BlackBox(Car car) {
    super(car);
  }

  @Override
  public void start() {
    car.start();
    System.out.println("녹화 시작!");
  }

  @Override
  public void stop() {
    car.stop();
    System.out.println("녹화 종료!");
  }

  @Override
  public void run() {
    car.run();
  }
}
