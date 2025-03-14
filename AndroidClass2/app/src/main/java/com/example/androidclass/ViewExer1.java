package com.example.androidclass;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViewExer1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_exer1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edTextNome = findViewById(R.id.editTextNome);
        EditText edTextIdade = findViewById(R.id.editTextIdade);
        Button btnEnviar = findViewById(R.id.button);




        btnEnviar.setOnClickListener( v -> {
            String nome = edTextNome.getText().toString().trim();
            String idadeStr = edTextIdade.getText().toString().trim();

            // Verificando se os campos estão vazios
            if (nome.isEmpty() || idadeStr.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    int idade = Integer.parseInt(idadeStr);

                    if (idade >= 18) {
                        Toast.makeText(this, nome + " você é maior de idade.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, nome + " você é menor de idade.", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Idade inválida!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    public void voltar(View view){finish();}
}