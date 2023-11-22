package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The main class for the voting system.
 */
public class Main {
  /**
   * The main method of the voting system.
   *
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    VotingManagement votingManagement = new VotingManagement();

    registerCandidate(scanner, votingManagement);
    registerElector(scanner, votingManagement);
    conductVoting(scanner, votingManagement);
  }


  public static void registerCandidate(Scanner scanner, VotingManagement votingManagement) {
    boolean candidateRegister = true;

    while (candidateRegister) {
      System.out.println("""
          Register new candidate?
          1 - Yes
          2 - No""");
      int response = scanner.nextInt();
      scanner.nextLine();

      if (response == 1) {
        System.out.println("Enter the candidate's name:");
        String name = scanner.nextLine();
        System.out.println("Enter the candidate's number:");
        int number = scanner.nextInt();
        scanner.nextLine();
        votingManagement.registerCandidate(name, number);
      } else {
        candidateRegister = false;
      }
    }
  }

  public static void registerElector(Scanner scanner, VotingManagement votingManagement) {
    boolean electorRegister = true;
    while (electorRegister) {
      System.out.println("""
          Register new elector?
          1 - Yes
          2 - No""");
      int response = scanner.nextInt();
      scanner.nextLine();

      if (response == 1) {
        System.out.println("Enter the elector's name:");
        String name = scanner.nextLine();
        System.out.println("Enter the elector's CPF:");
        String cpf = scanner.nextLine();
        votingManagement.registerElector(name, cpf);
      } else {
        electorRegister = false;
      }
    }
  }

  public static void conductVoting(Scanner scanner, VotingManagement votingManagement) {
    boolean voting = true;
    while (voting) {
      System.out.println("""
          Enter the corresponding number:
          1 - Vote
          2 - Partial results
          3 - Finish voting""");

      int response;
      String cpf;

      try {
        response = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Please, enter a valid number.");
        continue;
      }

      switch (response) {
        case 1:
          System.out.println("Enter the elector's CPF:");
          cpf = scanner.nextLine();
          System.out.println("Enter the candidate's number:");
          int candidateNumber = scanner.nextInt();
          scanner.nextLine();
          votingManagement.vote(cpf, candidateNumber);
          break;
        case 2:
          votingManagement.displayResults();
          break;
        case 3:
          votingManagement.displayResults();
          voting = false;
          break;
        default:
          System.out.println("Invalid option. Please, enter a valid number.");
      }
    }
  }
}
