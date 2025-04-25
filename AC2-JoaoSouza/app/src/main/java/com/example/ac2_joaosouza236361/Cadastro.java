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

        // Listener do botão de cadastrar exercício
        btnCadastrarTreino.setOnClickListener(v -> {
            String nome = editTextNome.getText().toString();
            String tempoStr = editTextTempo.getText().toString();

            if (!nome.isEmpty() && !tempoStr.isEmpty()) {
                int tempo = Integer.parseInt(tempoStr);

                // Recupera lista vinda da MainActivity
                ArrayList<Exercicio> lista = (ArrayList<Exercicio>) getIntent().getSerializableExtra("lista");
                if (lista == null) {
                    lista = new ArrayList<>();
                }

                lista.add(new Exercicio(nome, tempo));

                // Envia de volta
                Intent resultIntent = new Intent();
                resultIntent.putExtra("lista", lista);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        // Voltar pra tela principal (opcional)
        btnBackMain.setOnClickListener(v -> finish());
    }
}
