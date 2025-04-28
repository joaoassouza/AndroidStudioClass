package com.example.ac2_joaosouza236361;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnChangeView, btnIniciarTreino;
    TextView TxtViewTimer, TxtViewTreino;
    ListView ListViewExercicios;
    ArrayAdapter<Exercicio> adapter;

    int posicaoAtual = 0; // Qual exercício estamos
    CountDownTimer countDownTimer;
    static final String CHANNEL_ID = "treino_channel";

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

        btnChangeView = findViewById(R.id.btnChangeView);
        btnIniciarTreino = findViewById(R.id.btnIniciarTreino);
        TxtViewTimer = findViewById(R.id.txtViewTimer);
        TxtViewTreino = findViewById(R.id.TxtViewTreino);
        ListViewExercicios = findViewById(R.id.ListViewExercicios);

        btnChangeView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Cadastro.class);
            startActivity(intent);
        });

        btnIniciarTreino.setOnClickListener(v -> iniciarTreino());

        criarCanalNotificacao();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ExercicioStorage.listaExercicios);
        ListViewExercicios.setAdapter(adapter);
    }

    private void iniciarTreino() {
        if (ExercicioStorage.listaExercicios.isEmpty()) {
            TxtViewTreino.setText("Nenhum exercício cadastrado!");
            return;
        }
        posicaoAtual = 0;
        iniciarExercicio();
    }

    private void iniciarExercicio() {
        if (posicaoAtual >= ExercicioStorage.listaExercicios.size()) {
            TxtViewTreino.setText("Treino concluído!");
            TxtViewTimer.setText("0s");
            enviarNotificacao("Treino concluído! Parabéns!");
            return;
        }

        Exercicio exercicioAtual = ExercicioStorage.listaExercicios.get(posicaoAtual);
        TxtViewTreino.setText(exercicioAtual.getNome());

        enviarNotificacao("Iniciando: " + exercicioAtual.getNome());

        countDownTimer = new CountDownTimer(exercicioAtual.getTempo() * 1000L, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int segundosRestantes = (int) (millisUntilFinished / 1000);
                TxtViewTimer.setText(segundosRestantes + "s");
            }

            @Override
            public void onFinish() {
                posicaoAtual++;
                iniciarExercicio(); // Vai para o próximo exercício
            }
        }.start();
    }

    private void criarCanalNotificacao() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Treino Channel";
            String description = "Canal para notificações de treino";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

    private void enviarNotificacao(String mensagem) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("AC2 Treino Físico")
                .setContentText(mensagem)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.notify((int) System.currentTimeMillis(), builder.build());
        }
    }
}
