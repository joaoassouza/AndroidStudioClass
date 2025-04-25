package com.example.ac2_joaosouza236361;

public class Exercicio {

    private String nome;
    private int duracao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Exercicio() {
    }

    public Exercicio(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }
}
