package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class InputPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_page);
    }

        EditText tx = (EditText) findViewById(R.id.editTextNuminputtries);
        int uerinputtries = Integer.parseInt(tx.getText().toString());


}