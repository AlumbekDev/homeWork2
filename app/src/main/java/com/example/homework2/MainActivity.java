package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

Button btnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnButton =(Button) findViewById(R.id.nextActivity);
        btnButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,helt.class);
            startActivity(intent);
        });



    }
}