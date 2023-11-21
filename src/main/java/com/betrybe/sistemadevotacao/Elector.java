package com.betrybe.sistemadevotacao;

/**
 * Represents an elector in the voting system.
 * This class extends the Person class and includes additional information:
 * - Person's CPF.
 *
 * @see Person
 */
public class Elector extends Person {

  /**
   * Elector's CPF.
   * Will be reasigned a value when registering a new elector.
   */
  private String cpf;

  /**
   * Elector's CPF attribute Getter.
   *
   * @return The elector's CPF.
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * Elector's CPF attribute Setter.
   *
   * @param cpf The elector's CPF.
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * The Elector's class constructor.
   *
   * @param name The elector's name.
   * @param cpf The elector's CPF.
   */
  public Elector(String name, String cpf) {
    this.name = name;
    this.cpf = cpf;
  }
}
