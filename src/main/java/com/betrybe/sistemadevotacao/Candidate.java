package com.betrybe.sistemadevotacao;

/**
 * Represents a candidate in the voting system.
 * This class extends the Person class and includes additional information:
 * - Candidate's number;
 * - Number of votes received.
 *
 * @see Person
 */
public class Candidate extends Person {

  /**
   * Candidate's number.
   * Will be reasigned a value when registering a new candidate.
   */
  int number = 0;

  /**
   * Candidate's number attribute Getter.
   *
   * @return The candidate's number.
   */
  public int getNumber() {
    return number;
  }

  /**
   * Candidate's number attribute Setter.
   *
   * @param number The candidate's number.
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * Number of votes the candidate received.
   * Initialized with zero and incremented each time the candidate receives a vote.
   */
  int votes = 0;

  /**
   * Candidate's votes attribute Getter.
   *
   * @return The number of votes the candidate received.
   */
  public int getVotes() {
    return votes;
  }

  /**
   * The Candidate's class constructor.
   *
   * @param name The candidate's name
   * @param number The candidate's number
   */
  public Candidate(String name, int number) {
    this.number = number;
    this.name = name;
  }

  /**
   * Adds 1 to the candidate's votes attribute.
   */
  public void countVote() {
    votes += 1;
  }
}
