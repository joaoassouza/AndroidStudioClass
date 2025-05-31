package com.example.finalproject_petshop.controller;

import com.example.finalproject_petshop.models.Pet;
import com.example.finalproject_petshop.utils.FirebaseUtils;
import com.google.firebase.firestore.FirebaseFirestore;

public class PetController {

    private final FirebaseFirestore db = FirebaseUtils.getDatabase();

    public void adicionarPet(Pet pet) {
        db.collection("pets")
                .document(pet.getId())
                .set(pet);
    }

    public void deletarPet(String id) {
        db.collection("pets").document(id).delete();
    }

}