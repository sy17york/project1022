package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class WinPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_page);
        Intent intent = getIntent();
        String score = intent.getStringExtra("Score");
    }

    private int winscoredisplay;
    private String winner_name;


    public int getWinscoredisplay(){
        return this.winscoredisplay;
    }
    public void setWinscoredisplay(int score){
        this.winscoredisplay = score;
    }
    public void win_score(){
        TextView textView = findViewById(R.id.winscore_display);
        textView.setText(winscoredisplay);
    }
    public String add_score(){
        ImageButton button = findViewById(R.id.add_scorebutton);
        button.setOnClickListener(view -> {
            EditText user_input = findViewById(R.id.name_input);
            winner_name = user_input.getText().toString();
        });
        return this.winner_name;
    }
}