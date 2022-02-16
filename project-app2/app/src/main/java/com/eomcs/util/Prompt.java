package com.eomcs.util;

import java.util.Scanner;

public class Prompt {

  static Scanner keyScan = new Scanner(System.in);

  public static String promptString(String title, Object... args) {
    System.out.print(String.format(title, args));
    return keyScan.nextLine();
  }

  public static int promptInt(String title, Object... args) {
    return Integer.parseInt(promptString(title, args));
  }

}
