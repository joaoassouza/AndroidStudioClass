package com.example.androidclass;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViewExer2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_exer2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editTextn1 = findViewById(R.id.textViewNumero1);
        EditText ediTextn2 = findViewById(R.id.textViewNumero2);

        TextView tvResultado = findViewById(R.id.textvResultado);

        Button btnSomar = findViewById(R.id.btnSomar);
        Button btnDividir = findViewById(R.id.btnDividir);
        Button btnSubtrair = findViewById(R.id.btnSubtrair);
        Button btnMultiplicar = findViewById(R.id.btnMultiplicar);


        //somar
        btnSomar.setOnClickListener(v -> {
            String strN1 = editTextn1.getText().toString().trim();
            String strN2 = ediTextn2.getText().toString().trim();

            if (strN1.isEmpty() || strN2.isEmpty()) {
                Toast.makeText(this, "Insira os valores", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                double n1 = Double.parseDouble(strN1);
                double n2 = Double.parseDouble(strN2);
                double resultado = n1 + n2;

                tvResultado.setText(String.valueOf(resultado));

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Insira números válidos!", Toast.LENGTH_LONG).show();
            }
        });

        //subtrair
        btnSubtrair.setOnClickListener(v -> {
            String strN1 = editTextn1.getText().toString().trim();
            String strN2 = ediTextn2.getText().toString().trim();

            if (strN1.isEmpty() || strN2.isEmpty()) {
                Toast.makeText(this, "Insira os valores", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                double n1 = Double.parseDouble(strN1);
                double n2 = Double.parseDouble(strN2);
                double resultado = n1 - n2;

                tvResultado.setText(String.valueOf(resultado));

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Insira números válidos!", Toast.LENGTH_LONG).show();
            }
        });

        //multiplicar
        btnMultiplicar.setOnClickListener(v -> {
            String strN1 = editTextn1.getText().toString().trim();
            String strN2 = ediTextn2.getText().toString().trim();

            if (strN1.isEmpty() || strN2.isEmpty()) {
                Toast.makeText(this, "Insira os valores", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                double n1 = Double.parseDouble(strN1);
                double n2 = Double.parseDouble(strN2);
                double resultado = n1 * n2;

                tvResultado.setText(String.valueOf(resultado));

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Insira números válidos!", Toast.LENGTH_LONG).show();
            }
        });

        //dividir
        btnDividir  .setOnClickListener(v -> {
            String strN1 = editTextn1.getText().toString().trim();
            String strN2 = ediTextn2.getText().toString().trim();

            if (strN1.isEmpty() || strN2.isEmpty()) {
                Toast.makeText(this, "Insira os valores", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                double n1 = Double.parseDouble(strN1);
                double n2 = Double.parseDouble(strN2);
                double resultado = n1 / n2;

                if (n2 == 0){
                    Toast.makeText(this, "Não é possível dividir por 0", Toast.LENGTH_LONG).show();
                }
                else {
                tvResultado.setText(String.valueOf(resultado));}

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Insira números válidos!", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void voltar(View view){finish();}

}