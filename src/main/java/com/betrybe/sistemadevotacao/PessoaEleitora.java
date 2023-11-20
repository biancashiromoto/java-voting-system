package com.betrybe.sistemadevotacao;

/**
 * PessoaEleitora.
 */
public class PessoaEleitora extends Pessoa {
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
   * @param nome Elector's name
   *
   * @param cpf Elector's cpf
   */
  public PessoaEleitora(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }
}
