package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Principal.
 */
public class Principal {

  /**
   * Main method.
   *
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao votingManagement = new GerenciamentoVotacao();
    boolean candidateRegister = true;
    boolean electorRegister = false;
    boolean voting = false;

    while (candidateRegister) {
      System.out.println("""
          Cadastrar pessoa candidata?
          1 - Sim
          2 - Não
          Entre com o número correspondente à opção desejada:""");
      int response = scanner.nextInt();
      scanner.nextLine();

      if (response == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String name = scanner.nextLine();
        System.out.println("Entre com o número da pessoa candidata:");
        int number = scanner.nextInt();
        scanner.nextLine();
        votingManagement.cadastrarPessoaCandidata(name, number);
      } else {
        candidateRegister = false;
        electorRegister = true;
      }
    }

    while (electorRegister) {
      System.out.println("""
          Cadastrar pessoa eleitora?
          1 - Sim
          2 - Não
          Entre com o número correspondente à opção desejada:""");
      int response = scanner.nextInt();
      scanner.nextLine();

      if (response == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String name = scanner.nextLine();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.nextLine();
        votingManagement.cadastrarPessoaEleitora(name, cpf);
      } else {
        electorRegister = false;
        voting = true;
      }
    }

    while (voting) {
      System.out.println("""
          Entre com o número correspondente à opção desejada:
          1 - Votar
          2 - Resultado Parcial
          3 - Finalizar Votação""");

      int response;
      String cpf;

      try {
        response = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Por favor, entre com um número válido.");
        continue;
      }

      switch (response) {
        case 1:
          System.out.println("Entre com o cpf da pessoa eleitora:");
          cpf = scanner.nextLine();
          System.out.println("Entre com o número da pessoa candidata:");
          int candidateNumber = scanner.nextInt();
          scanner.nextLine();
          votingManagement.votar(cpf, candidateNumber);
          break;
        case 2:
          votingManagement.mostrarResultado();
          break;
        case 3:
          votingManagement.mostrarResultado();
          voting = false;
          break;
        default:
          break;
      }
    }
  }
}
