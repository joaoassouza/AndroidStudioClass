package com.example.androidclass;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewExer4 extends AppCompatActivity {
    private List<CheckBox> checkBoxList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_exer4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //fazer o usuário digitar o nome na tela e, para cada letra do nome, um checkbox


        LinearLayout checkBoxContainer = findViewById(R.id.checkBoxContainer);
        EditText editTextnome = findViewById(R.id.editTextNomeEx4);
        Button btnEnviar = findViewById(R.id.btnEnviarEx4);

        btnEnviar.setOnClickListener(v -> {
            String nomeCompleto = editTextnome.getText().toString().trim();
            char[] letras = nomeCompleto.toCharArray();
            List<String> opcoes = new ArrayList<>();

            for (char letra : letras) {
                opcoes.add(String.valueOf(letra));
            }

            for (String opcao : opcoes)
            {
                CheckBox checkBox = new CheckBox(this);
                checkBox.setText(opcao);
                checkBoxContainer.addView(checkBox);
                checkBoxList.add(checkBox);
            }
        });

    }
    public void voltar(View view){finish();}

}