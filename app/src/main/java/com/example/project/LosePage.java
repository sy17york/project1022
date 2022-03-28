package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class LosePage extends AppCompatActivity {
    StoreData store_data;
    private final String[] winner_names = new String[10];
    private final String[] winner_scores = new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_page);
        //intent
        Intent intent = getIntent();
        String correct_number = intent.getStringExtra("Value");
        //score display
        TextView textView = findViewById(R.id.losescore_display);
        textView.setText(correct_number);
        //display top 10
        ImageButton button = findViewById(R.id.home_button);
        button.setOnClickListener(view -> {
            Intent home = new Intent(getApplicationContext(), MainPage.class);
            startActivity(home);
        });
        ImageButton button_ = findViewById(R.id.retry_button);
        button_.setOnClickListener(view -> {
            Intent retry = new Intent(getApplicationContext(), GamePage.class);
            startActivity(retry);
        });
    }



}