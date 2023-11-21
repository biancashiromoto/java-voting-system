package com.betrybe.sistemadevotacao.utils;

import java.util.Scanner;

public class Utils {
  public static int getIntInput() {
    Scanner scanner = new Scanner(System.in);
    int input = 0;
    boolean isValidInput = false;

    while(!isValidInput) {
      try {
        input = Integer.parseInt(scanner.nextLine());
        isValidInput = true;
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
      }
    }
    return input;
  }
}
