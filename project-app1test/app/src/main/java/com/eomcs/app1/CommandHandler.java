package com.eomcs.app1;

public class CommandHandler {

  void doAdd(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("명령어 입력 형식이 올바르지 않습니다.");
    } else {
      int v1 = Integer.valueOf(command.getInt(0));
      int v2 = Integer.valueOf(command.getInt(1));
      System.out.printf("%d + %d = %d\n", v1, v2, (v1 + v2));
    }
  }

  void doMinus(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("명령어 입력 형식이 올바르지 않습니다.");
    } else {
      int v1 = Integer.valueOf(command.getInt(0));
      int v2 = Integer.valueOf(command.getInt(1));
      System.out.printf("%d - %d = %d\n", v1, v2, (v1 - v2));
    }
  }

  void doHelp() {
    System.out.println("add   [값1] [값2]  더하기 계산을 수행한다.");
    System.out.println("minus [값1] [값2]  빼기 계산을 수행한다.");
  }
}
