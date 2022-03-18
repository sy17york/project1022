package com.example.project;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ActiveMain extends AppCompatActivity {



    public void add_score(){
        ImageButton button = findViewById(R.id.add_scorebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
