package com.example.finalproject_petshop.models;

public class HomeItem {
    private String clienteNome;
    private String petNome;
    private int qtdServicos;
    private String ultimoServico;

    public HomeItem() {}

    public HomeItem(String clienteNome, String petNome, int qtdServicos, String ultimoServico) {
        this.clienteNome = clienteNome;
        this.petNome = petNome;
        this.qtdServicos = qtdServicos;
        this.ultimoServico = ultimoServico;
    }

    // Getters e Setters...

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getPetNome() {
        return petNome;
    }

    public void setPetNome(String petNome) {
        this.petNome = petNome;
    }

    public int getQtdServicos() {
        return qtdServicos;
    }

    public void setQtdServicos(int qtdServicos) {
        this.qtdServicos = qtdServicos;
    }

    public String getUltimoServico() {
        return ultimoServico;
    }

    public void setUltimoServico(String ultimoServico) {
        this.ultimoServico = ultimoServico;
    }
}
