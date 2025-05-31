package com.example.finalproject_petshop.controller;

import com.example.finalproject_petshop.models.RegistroServico;
import com.example.finalproject_petshop.utils.FirebaseUtils;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegistroServicoController {

    private final FirebaseFirestore db = FirebaseUtils.getDatabase();

    public void registrarServico(RegistroServico registro) {
        db.collection("registros_servico")
                .document(registro.getId())
                .set(registro);
    }

}

