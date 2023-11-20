package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * GerenciamentoVotacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoasCandidata : pessoasCandidatas) {
      if (pessoasCandidata.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata newCandidate = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(newCandidate);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoasEleitora : pessoasEleitoras) {
      if (pessoasEleitora.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
      }
    }
    PessoaEleitora newElector = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(newElector);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    }

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
        pessoaCandidata.receberVoto();
      }
    }
    cpfsComputados.add(cpfPessoaEleitora);
  }

  @Override
  public void mostrarResultado() {
    int totalVotes = cpfsComputados.size();

    if (totalVotes == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
    for (PessoaCandidata candidate : pessoasCandidatas) {
      double percentage = ((double) candidate.getVotos() / totalVotes) * 100;
      System.out.printf(
          "Nome: %s - %s votos ( %s%% )%n",
          candidate.getNome(), candidate.getVotos(), Math.round(percentage)
      );
    }
    System.out.printf("Total de votos: %s%n", totalVotes);
  }
}
