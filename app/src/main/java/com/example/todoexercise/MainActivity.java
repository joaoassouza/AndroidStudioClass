package com.example.todoexercise;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextDescricao;
    private Button btnSalvar;
    private ListView listViewTarefas;
    private BancoHelper bancoHelper;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listaTarefas;
    private ArrayList<Integer> listaIds; // Para armazenar os IDs das tarefas

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

        // Inicializando componentes
        editTextNome = findViewById(R.id.editTextNome);
        editTextDescricao = findViewById(R.id.editTextDescricao);
        btnSalvar = findViewById(R.id.btnSalvar);
        listViewTarefas = findViewById(R.id.listViewTarefas);
        bancoHelper = new BancoHelper(this);

        // Configurar lista
        listaTarefas = new ArrayList<>();
        listaIds = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaTarefas);
        listViewTarefas.setAdapter(adapter);

        carregarTarefas(); // Carregar tarefas do banco

        // Evento do botão de salvar
        btnSalvar.setOnClickListener(v -> salvarTarefa());

        // Excluir tarefa ao clicar na lista
        listViewTarefas.setOnItemClickListener((parent, view, position, id) -> {
            int tarefaId = listaIds.get(position); // Obtém o ID da tarefa clicada
            bancoHelper.excluirTarefa(tarefaId); // Exclui do banco
            carregarTarefas(); // Atualiza a lista
            Toast.makeText(MainActivity.this, "Tarefa excluída!", Toast.LENGTH_SHORT).show();
        });
    }

    private void salvarTarefa() {
        String nome = editTextNome.getText().toString().trim();
        String descricao = editTextDescricao.getText().toString().trim();

        if (nome.isEmpty() || descricao.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        bancoHelper.adicionarTarefa(nome, descricao, 0); // Status 0 = pendente
        Toast.makeText(this, "Tarefa salva!", Toast.LENGTH_SHORT).show();

        editTextNome.setText("");
        editTextDescricao.setText("");

        carregarTarefas(); // Atualiza a lista
    }

    private void carregarTarefas() {
        listaTarefas.clear();
        listaIds.clear();

        Cursor cursor = bancoHelper.listarTarefas();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String nome = cursor.getString(1);
                String descricao = cursor.getString(2);
                int status = cursor.getInt(3);

                String statusTexto = (status == 0) ? "[Pendente] " : "[Concluída] ";
                listaTarefas.add(statusTexto + nome + " - " + descricao);
                listaIds.add(id);

            } while (cursor.moveToNext());

            cursor.close();
        }

        adapter.notifyDataSetChanged();
    }
}
