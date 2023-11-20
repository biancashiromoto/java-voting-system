package com.betrybe.sistemadevotacao;

/**
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

  public PessoaCandidata(String nome, int numero) {
    this.numero = numero;
    this.votos = 0;
    this.nome = nome;
  }

  public void receberVoto() {
    votos += 1;
  }
}
