// 디폴트 메서드의 다중 구현
package com.eomcs.oop.ex09.c;


public class Exam0310 {

  interface ProtocolA {
    void rule1();
    default void rule3() {
      System.out.println("**ProtocolA.rule3()**");
    }
  }

  interface ProtocolB {
    void rule2();
    default void rule3() {
      System.out.println("=====> ProtocolB.rule3()");
    }
  }

  // 다중 인터페이스를 구현이 불가한 경우,
  // - 메서드 이름만 같고
  //   메서드 시그너처의 다른 부분(파라미터, 리턴타입)이 다른 경우.
  // - 두 인터페이스를 모두 만족시키지 못하기 때문이다.
  //
  static class ProtocolImpl implements ProtocolA, ProtocolB {

    // ProtocolA 규칙 준수!
    @Override
    public void rule1() {
      System.out.println("ProtocolImpl.rule1()");
    }

    // ProtocolB 규칙 준수!
    @Override
    public void rule2() {
      System.out.println("ProtocolImpl.rule2()");
    }

    // 인터페이스들에 같은 시그너처를 갖는 default method가 여러 개 있을 경우,
    // 어떤 메서드를 상속 받느냐에 따라 실행 결과가 달라지기 때문에
    // 다중 클래스 상속이 불가능한 것 처럼
    // 이 경우에도 다중 인터페이스 구현이 불가능하다!
    //
    // 그러나, 다음과 같이 클래스에서 default 메서드를 오버라이딩 한다면,
    // 어차피 인터페이스에서 구현한 default 메서드를 사용하지 않기 때문에
    // 이 경우에는 다중 구현이 가능하다.
    // 
    @Override
    public void rule3() {
      System.out.println("ProtocolImpl.rule3()");
    }
  }

  public static void main(String[] args) {

    ProtocolImpl obj = new ProtocolImpl();
    obj.rule1();
    obj.rule2();
    obj.rule3();
  }
}







