package com.example.threadsclass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        minhaThread t = new minhaThread();
        t.start();

        //CHAMANDO SERVICO
        Intent i = new Intent(this, MeuServico.class);
        startService(i);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    class minhaThread extends Thread {

        public void run() {
            try {
                Thread.sleep(0);
                TextView t = (TextView) findViewById(R.id.textView4);
                t.setText("Thread Iniciada");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}