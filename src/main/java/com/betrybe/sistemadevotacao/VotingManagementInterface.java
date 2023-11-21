package com.betrybe.sistemadevotacao;

/**
 * Interface para o gerenciamento de votação.
 */
public interface VotingManagementInterface {

  void registerCandidate(String nome, int numero);

  void registerElector(String nome, String cpf);

  void vote(String cpfPessoaEleitora, int numeroPessoaCandidata);

  void displayResults();
}
