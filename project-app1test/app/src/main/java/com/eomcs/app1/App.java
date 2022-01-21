package com.eomcs.app1;

public class App {


  public static void main(String[] args) {

    CommandHandler commandHandler = new CommandHandler();
    Console console = new Console();

    while (true) {
      Command command = console.inputCommand();

      if (command.getName().equals("quit") || command.getName().equals("exit")) {
        break;
      }

      if (command.getName().equals("help")) {
        commandHandler.doHelp();

      } else {
        if (command.getName().equals("add")) {
          commandHandler.doAdd(command);
        } else if (command.getName().equals("minus")) {
          commandHandler.doMinus(command);
        } else {
          System.out.println("지원하지 않는 연산자 입니다.");
        } 
      }
    }
    console.keyScan.close();

  }




}
