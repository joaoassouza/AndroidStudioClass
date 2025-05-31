package com.example.finalproject_petshop.controller;

import com.example.finalproject_petshop.models.Servico;
import com.example.finalproject_petshop.utils.FirebaseUtils;
import com.google.firebase.firestore.FirebaseFirestore;

public class ServicoController {

    private final FirebaseFirestore db = FirebaseUtils.getDatabase();

    public void adicionarServico(Servico servico) {
        db.collection("servicos")
                .document(servico.getId())
                .set(servico);
    }

    public void deletarServico(String id) {
        db.collection("servicos").document(id).delete();
    }

}

