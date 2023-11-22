package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Represents the voting management system.
 * This class implements the VotingManagementInterface and includes additional information:
 * - A list of candidates;
 * - A list of electors;
 * - A list containing the CPFs of the electors who already voted.
 *
 * @see VotingManagementInterface
 */
public class VotingManagement implements VotingManagementInterface {

  /**
   * A list of registered candidates.
   */
  private ArrayList<Candidate> candidates = new ArrayList<Candidate>();
  /**
   * A list of registered electors.
   */
  private ArrayList<Elector> electors = new ArrayList<Elector>();
  /**
   * A list containing the CPFs of the electors who already voted.
   */
  private ArrayList<String> countedCpfs = new ArrayList<String>();

  /**
   * Register a new candidate and adds their information to the candidates list. The candidate's number must not be in the candidates list.
   *
   * @param name The candidate's name.
   * @param number The candidate's number.
   */
  @Override
  public void registerCandidate(String name, int number) {
    for (Candidate candidate : candidates) {
      if (candidate.getNumber() == number) {
        System.out.println("""
            _________________________________________________
            There is already a candidate registered under this number.
            _________________________________________________""");
        return;
      }
    }
    Candidate newCandidate = new Candidate(name, number);
    candidates.add(newCandidate);
  }

  /**
   * Register a new elector and adds their information to the electors list. The elector's CPF must not be in the electors list.
   *
   * @param name The elector's name.
   * @param cpf The elector's cpf.
   */
  @Override
  public void registerElector(String name, String cpf) {
    for (Elector elector : electors) {
      if (elector.getCpf().equals(cpf)) {
        System.out.println("""
            _________________________________________________
            There is already an elector registered under this CPF.
            _________________________________________________""");
        return;
      }
    }
    Elector newElector = new Elector(name, cpf);
    electors.add(newElector);
  }

  /**
   * Register a vote to the candidate using the elector's CPF if the elector's CPF is not already registered in the countedCpfs list.
   *
   * @param electorsCpf The elector's CPF.
   * @param candidatesNumber The candidate's number.
   */
  @Override
  public void vote(String electorsCpf, int candidatesNumber) {
    if (countedCpfs.contains(electorsCpf)) {
      System.out.println("""
            _________________________________________________
            This elector has already voted.
            _________________________________________________""");
      return;
    }

    boolean candidateFound = false;
    for (Candidate candidate : candidates) {
      if (candidate.getNumber() == candidatesNumber) {
        candidate.countVote();
        candidateFound = true;
        break;
      }
    }
    if (!candidateFound) {
      System.out.println("""
            _________________________________________________
            There is no candidate registered under that number.
            _________________________________________________""");
    } else {
      countedCpfs.add(electorsCpf);
      System.out.println("""
          _________________________________________________
          Vote successfully registered!
          _________________________________________________""");
    }
  }

  /**
   * Prints the voting results.
   */
  @Override
  public void displayResults() {
    int totalVotes = countedCpfs.size();

    if (totalVotes == 0) {
      System.out.println("There must be at least one vote.");
    }
    System.out.println("_________________________________________________");
    System.out.printf("| %-12s | %-8s | %-6s |%n", "CANDIDATO", "VOTOS", "PERCENT");
    System.out.println("_________________________________________________");

    for (Candidate candidate : candidates) {
      double percentage = ((double) candidate.getVotes() / totalVotes) * 100;
      System.out.printf("| %-12s | %-8d | %-6s%% |%n",
          candidate.getName(), candidate.getVotes(), Math.round(percentage));
    }

    System.out.printf("| %-12s | %-8s | %-6s |%n ", "Total votes", totalVotes, "100");
    System.out.println("_________________________________________________");
  }
}
