package com.example.ac2_joaosouza236361;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cadastro extends AppCompatActivity {

    EditText editTextNome, editTextTempo;
    Button btnCadastrarTreino, btnBackMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro); // IMPORTANTE: antes do findViewById

        editTextNome = findViewById(R.id.editTextNomeExer);
        editTextTempo = findViewById(R.id.EditTextTempo);
        btnCadastrarTreino = findViewById(R.id.btnSalvarExercicio);
        btnBackMain = findViewById(R.id.btnChangeViewBackMain);

        btnCadastrarTreino.setOnClickListener(v -> {
            String nome = editTextNome.getText().toString();
            String tempoStr = editTextTempo.getText().toString();

            if (!nome.isEmpty() && !tempoStr.isEmpty()) {
                int tempo = Integer.parseInt(tempoStr);
                ExercicioStorage.listaExercicios.add(new Exercicio(nome, tempo));
                finish();
            }
        });

        btnBackMain.setOnClickListener(v -> finish());
    }
}
