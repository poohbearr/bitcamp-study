package com.eomcs.app1;

import java.util.Arrays;
import java.util.Scanner;

public class Console {

  Scanner keyScan = new Scanner(System.in);

  Command inputCommand() {
    System.out.print(">");
    String[] values = this.keyScan.nextLine().split(" ");
    return new Command(values[0], Arrays.copyOfRange(values, 1, values.length));
  }

  void close() {
    this.keyScan.close();
  }
}
