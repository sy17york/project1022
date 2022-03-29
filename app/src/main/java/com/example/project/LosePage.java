package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class LosePage extends AppCompatActivity {
    StoreData store_data;

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
        String[] winner_names = store_data.getNames();
        String[] winner_scores = store_data.getScores();
        for (int i = 0;i<10;i++){
            String text_id = "score_top"+(i+1);
            int resourceId = this.getResources().getIdentifier(text_id,"string", this.getPackageName());
            TextView top = findViewById(resourceId);
            String top1_text = winner_names[i]+ "-"+ winner_scores[i];
            top.setText(top1_text);
        }





        //Home and retry buttons
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