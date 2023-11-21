package com.betrybe.sistemadevotacao;

/**
 * {@summary Candidate.}
 * Pessoa candidata.
 */
public class Candidate extends Person {
  int number = 0;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  int votes = 0;

  public int getVotes() {
    return votes;
  }

  /**
   * {@summary Candidate.}
   *
   * @param name Candidate's name
   *
   * @param number Candidate's number
   */
  public Candidate(String name, int number) {
    this.number = number;
    this.name = name;
  }

  public void countVote() {
    votes += 1;
  }
}
