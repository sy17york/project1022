package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Field;

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
        store_data = new StoreData();
        String[] display_scores = store_data.getScores(this, "AppScores");
        String[] display_names = store_data.getNames(this, "AppNames");
        for (int i = 0; i<10; i++){
            if(display_scores[i]!=null) {
                String score_id = "score_top" + (i + 1);
                String display = (i + 1) + "." + display_names[i] + " -> " + display_scores[i];
                int resID = this.getResources().getIdentifier(score_id, "id", this.getPackageName());
                TextView text = findViewById(resID);
                text.setText(display);
            }
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