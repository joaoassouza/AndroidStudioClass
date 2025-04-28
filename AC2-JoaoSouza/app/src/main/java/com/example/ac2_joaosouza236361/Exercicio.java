package com.example.ac2_joaosouza236361;

public class Exercicio {

    private String nome;
    private int tempo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Exercicio() {
    }

    public Exercicio(String nome, int duracao) {
        this.nome = nome;
        this.tempo = duracao;
    }
}
