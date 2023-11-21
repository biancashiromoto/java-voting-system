package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * GerenciamentoVotacao.
 */
public class VotingManagement implements VotingManagementInterface {

  private ArrayList<Candidate> candidates = new ArrayList<Candidate>();
  private ArrayList<Elector> electors = new ArrayList<Elector>();
  private ArrayList<String> countedCpfs = new ArrayList<String>();

  @Override
  public void registerCandidate(String name, int number) {
    for (Candidate candidate : candidates) {
      if (candidate.getNumber() == number) {
        System.out.println("Candidate's number already used!");
        return;
      }
    }
    Candidate newCandidate = new Candidate(name, number);
    candidates.add(newCandidate);
  }

  @Override
  public void registerElector(String name, String cpf) {
    for (Elector elector : electors) {
      if (elector.getCpf().equals(cpf)) {
        System.out.println("Elector already registered!");
      }
    }
    Elector newElector = new Elector(name, cpf);
    electors.add(newElector);
  }

  @Override
  public void vote(String electorsCpf, int cadidatesNumber) {
    if (countedCpfs.contains(electorsCpf)) {
      System.out.println("Elector already voted!");
    }

    for (Candidate candidate : candidates) {
      if (candidate.getNumber() == cadidatesNumber) {
        candidate.countVote();
      }
    }
    countedCpfs.add(electorsCpf);
  }

  @Override
  public void displayResults() {
    int totalVotes = countedCpfs.size();

    if (totalVotes == 0) {
      System.out.println("There must be at least one vote.");
    }
    for (Candidate candidate : candidates) {
      double percentage = ((double) candidate.getVotes() / totalVotes) * 100;
      System.out.printf(
          "Name: %s - %s votes ( %s%% )%n",
          candidate.getName(), candidate.getVotes(), Math.round(percentage)
      );
    }
    System.out.printf("Total votes: %s%n", totalVotes);
  }
}
