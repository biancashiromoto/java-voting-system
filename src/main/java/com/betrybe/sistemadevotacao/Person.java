package com.betrybe.sistemadevotacao;

/**
 * Represents a person in the voting system.
 * Serves as the base class for specific person types.
 *
 * @see Candidate
 * @see Elector
 */
abstract class Person {

  /**
   * The person's name.
   */
  protected String name;

  /**
   * The person's name attribute Getter.
   *
   * @return The person's name.
   */
  public String getName() {
    return name;
  }

  /**
   * The person's name attribute Setter.
   *
   * @param name The person's name.
   */
  public void setName(String name) {
    this.name = name;
  }
}
