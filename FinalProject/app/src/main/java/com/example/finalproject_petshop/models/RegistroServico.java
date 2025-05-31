package com.example.finalproject_petshop.models;

import java.util.Date;

public class RegistroServico {
    private String id;
    private String clienteId;
    private String petId;
    private String servicoId;
    private Date data;

    public RegistroServico() {}

    public RegistroServico(String id, String clienteId, String petId, String servicoId, Date data) {
        this.id = id;
        this.clienteId = clienteId;
        this.petId = petId;
        this.servicoId = servicoId;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getServicoId() {
        return servicoId;
    }

    public void setServicoId(String servicoId) {
        this.servicoId = servicoId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

