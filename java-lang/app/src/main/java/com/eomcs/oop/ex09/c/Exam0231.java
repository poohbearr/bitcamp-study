// 메서드의 시그너처가 다르다면 당연히 다중 구현 가능
package com.eomcs.oop.ex09.c;


public class Exam0231 {

  interface ProtocolA {
    void rule0(int a);
    void rule1();
  }

  interface ProtocolB {
    int rule0();
    void rule2();
  }

  // 다중 인터페이스를 구현이 불가한 경우,
  // - 메서드 이름만 같고
  //   메서드 시그너처의 다른 부분(파라미터, 리턴타입)이 다른 경우.
  // - 두 인터페이스를 모두 만족시키지 못하기 때문이다.
  //
  class ProtocolImpl implements ProtocolA, ProtocolB {

    // ProtocolA 규칙 준수!
    @Override
    public void rule0(int a) {}

    // ProtocolB 규칙 준수!
    @Override
    public int rule0() {return 0;}

    // ProtocolA 규칙 준수!
    @Override
    public void rule1() {}

    // ProtocolB 규칙 준수!
    @Override
    public void rule2() {}
  }

  public static void main(String[] args) {
  }
}







