package com.betrybe.sistemadevotacao;

import com.betrybe.sistemadevotacao.utils.Utils;
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

    selectOption(scanner, votingManagement);
  }

  public static void selectOption(Scanner scanner, VotingManagement votingManagement) {
    boolean loop = true;

    while (loop) {
      System.out.println("""
        _________________________________________________
        Select one option below:
        1 - Register new candidate
        2 - Register new elector
        3 - Voting options
        Press any other key to leave.
        _________________________________________________""");

      int response = Utils.getIntInput();

      switch (response) {
        case 1:
          registerCandidate(scanner, votingManagement);
          break;
        case 2:
          registerElector(scanner, votingManagement);
          break;
        case 3:
          conductVoting(scanner, votingManagement);
          break;
        default:
          System.out.println("""
        _________________________________________________
        Exiting...
        _________________________________________________""");
          loop = false;
      }
    }
  }

  public static void registerCandidate(Scanner scanner, VotingManagement votingManagement) {
    System.out.println("Enter the candidate's name:");
    String name = scanner.nextLine();
    System.out.println("Enter the candidate's number:");
    int number = scanner.nextInt();
    scanner.nextLine();
    votingManagement.registerCandidate(name, number);
    System.out.println("""
        _________________________________________________
        Candidate successfully registered.
        _________________________________________________""");
  }

  public static void registerElector(Scanner scanner, VotingManagement votingManagement) {
    System.out.println("Enter the elector's name:");
    String name = scanner.nextLine();
    System.out.println("Enter the elector's CPF:");
    String cpf = scanner.nextLine();
    votingManagement.registerElector(name, cpf);
    System.out.println("""
        _________________________________________________
        Elector successfully registered.
        _________________________________________________""");
  }

  public static void conductVoting(Scanner scanner, VotingManagement votingManagement) {
    boolean voting = true;
    while (voting) {
      System.out.println("""
          _________________________________________________
          Enter the corresponding number:
          1 - Vote
          2 - Partial results
          3 - Finish voting
          _________________________________________________""");

      String cpf;

      int response = Utils.getIntInput();

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
          System.out.println("""
        _________________________________________________
        Invalid option. Please, enter a valid number.
        _________________________________________________""");
      }
    }
  }
}
