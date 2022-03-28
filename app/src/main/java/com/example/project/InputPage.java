package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputPage extends AppCompatActivity {
    Button inputNumbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_page);
        //Intent i = getIntent().getExtras();
        String mode = getIntent().getStringExtra("Mode");
        EditText tx = (EditText) findViewById(R.id.editTextNuminputtries);
        inputNumbutton = findViewById(R.id.inputPagebutton);
        inputNumbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),GamePage.class);
                intent.putExtra("Mode", mode);
                String input = tx.getText().toString();
                intent.putExtra("Inputtries",input);
                startActivity(intent);
            }
        });
    }




}