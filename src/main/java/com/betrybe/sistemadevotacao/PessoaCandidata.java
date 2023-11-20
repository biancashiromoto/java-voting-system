package com.betrybe.sistemadevotacao;

/**
 * {@summary Candidate.}
 * Pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {
  int numero = 0;

  public int getNumero() {
    return numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  int votos = 0;

  /**
   * {@summary Candidate.}
   *
   * @param nome Candidate's name
   *
   * @param numero Candidate's number
   */
  public PessoaCandidata(String nome, int numero) {
    this.numero = numero;
    this.nome = nome;
  }

  public void receberVoto() {
    votos += 1;
  }
}
