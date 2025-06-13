package com.example.finalproject_petshop;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_petshop.adapter.HomeAdapter;
import com.example.finalproject_petshop.models.HomeItem;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private List<HomeItem> listaHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerView); // certifique-se de que o ID exista no XML
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaHome = new ArrayList<>();
        homeAdapter = new HomeAdapter(listaHome);
        recyclerView.setAdapter(homeAdapter);

        carregarHome();
    }

    private void carregarHome() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("clientes").get().addOnSuccessListener(clientesSnap -> {
            for (QueryDocumentSnapshot clienteDoc : clientesSnap) {
                String clienteNome = clienteDoc.getString("nome");
                List<String> petsIds = (List<String>) clienteDoc.get("pets");

                if (petsIds != null) {
                    for (String petId : petsIds) {
                        db.collection("pets").document(petId).get().addOnSuccessListener(petDoc -> {
                            String petNome = petDoc.getString("nome");

                            db.collection("registros_servico")
                                    .whereEqualTo("petId", petId)
                                    .get().addOnSuccessListener(servicosSnap -> {

                                        int qtdServicos = servicosSnap.size();
                                        String ultimoServico = "";

                                        for (QueryDocumentSnapshot servicoDoc : servicosSnap) {
                                            String data = servicoDoc.getString("data"); // opcional
                                            ultimoServico = data; // simplificação, pegar o último lido
                                        }

                                        listaHome.add(new HomeItem(clienteNome, petNome, qtdServicos, ultimoServico));
                                        homeAdapter.notifyDataSetChanged();
                                    });
                        });
                    }
                }
            }
        });
    }
}
