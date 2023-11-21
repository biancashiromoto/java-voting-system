package com.betrybe.sistemadevotacao;

/**
 * PessoaEleitora.
 */
public class Elector extends Person {
  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * {@summary Elector.}
   *
   * @param name Elector's name
   *
   * @param cpf Elector's cpf
   */
  public Elector(String name, String cpf) {
    this.name = name;
    this.cpf = cpf;
  }
}
