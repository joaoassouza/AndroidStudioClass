package com.example.androidclass;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ViewExer5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_exer5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CheckBox cbLogin = findViewById(R.id.checkBoxLogin);
        CheckBox cbModoEscuro = findViewById(R.id.checkBoxModoEscuro);
        CheckBox cbNotificacao = findViewById(R.id.checkBoxNotif);
        Button btnSalvar = findViewById(R.id.buttonSalvarPrefe);
        ArrayList<String> opcoes = new ArrayList<>();


        btnSalvar.setOnClickListener( v -> {
            if (cbModoEscuro.isChecked()){
                opcoes.add(cbModoEscuro.getText().toString());
            }
            if (cbNotificacao.isChecked()){
                opcoes.add(cbNotificacao.getText().toString());
            }
            if (cbLogin.isChecked()){
                opcoes.add(cbLogin.getText().toString());
            }


            Toast.makeText(this, "Preferências salvas: " + TextUtils.join(", ", opcoes), Toast.LENGTH_LONG).show();
        });


    }
    public void voltar(View view){finish();}

}