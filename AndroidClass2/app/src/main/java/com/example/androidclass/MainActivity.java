package com.example.androidclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void carregarView1(View view){
        Intent intent = new Intent(MainActivity.this, ViewExer1.class);
        startActivity(intent);
    }

    public void carregarView2(View view){
        Intent intent = new Intent(MainActivity.this, ViewExer2.class);
        startActivity(intent);
    }

    public void carregarView3(View view){
        Intent intent = new Intent(MainActivity.this, ViewExer3.class);
        startActivity(intent);
    }

    public void carregarView4(View view){
        Intent intent = new Intent(MainActivity.this, ViewExer4.class);
        startActivity(intent);
    }

    public void carregarView5(View view){
        Intent intent = new Intent(MainActivity.this, ViewExer5.class);
        startActivity(intent);
    }


}