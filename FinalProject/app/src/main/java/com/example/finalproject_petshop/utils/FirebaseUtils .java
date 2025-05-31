package com.example.finalproject_petshop.utils;

import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtils {
    public static FirebaseFirestore getDatabase() {
        return FirebaseFirestore.getInstance();
    }
}
