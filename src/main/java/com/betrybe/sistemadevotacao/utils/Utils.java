package com.betrybe.sistemadevotacao.utils;

import java.util.Scanner;

public class Utils {
  public static int getIntInput() {
    Scanner scanner = new Scanner(System.in);
    boolean isInvalidInput = true;
    int response = 0;

    while (isInvalidInput) {
      try {
        response = Integer.parseInt(scanner.nextLine());
        isInvalidInput = false;
      } catch (NumberFormatException e) {
        System.out.println("""
            _________________________________________________
            Please, enter a valid number.
            _________________________________________________""");
        continue;
      }
    }
    return response;
  }
}
