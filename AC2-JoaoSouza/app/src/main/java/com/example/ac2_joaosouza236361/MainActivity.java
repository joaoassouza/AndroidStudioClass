package com.example.ac2_joaosouza236361;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnChangeView, btnIniciarTreino;
    TextView TxtViewTimer, TxtViewTreino;
    ListView ListViewExercicios;
    ArrayAdapter<Exercicio> adapter;

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

        // 👇 Aqui é o lugar certo para o findViewById
        btnChangeView = findViewById(R.id.btnChangeView);
        btnIniciarTreino = findViewById(R.id.btnIniciarTreino);
        TxtViewTimer = findViewById(R.id.txtViewTimer);
        TxtViewTreino = findViewById(R.id.TxtViewTreino);
        ListViewExercicios = findViewById(R.id.ListViewExercicios);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ExercicioStorage.listaExercicios);
        ListViewExercicios.setAdapter(adapter);
    }
}
