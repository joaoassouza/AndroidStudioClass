package com.example.finalproject_petshop.controller;

import com.example.finalproject_petshop.models.Cliente;
import com.example.finalproject_petshop.utils.FirebaseUtils;
import com.google.firebase.firestore.FirebaseFirestore;

public class ClienteController {

    private final FirebaseFirestore db = FirebaseUtils.getDatabase();

    public void adicionarCliente(Cliente cliente) {
        db.collection("clientes")
                .document(cliente.getId())
                .set(cliente);
    }

    public void deletarCliente(String id) {
        db.collection("clientes").document(id).delete();
    }

}

