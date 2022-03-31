package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LeaderboardsPage extends AppCompatActivity {
    StoreData store_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards_page);
        //getters for names and scores previous winners
        String[] leaderboard_names = store_data.getNames();
        String[] leaderboard_scores = store_data.getScores();
        //adds them to display
        for (int i = 0; i< leaderboard_names.length; i++){
            String text_id = "score_top"+(i+1);
            int resourceId = this.getResources().getIdentifier(text_id,"string", this.getPackageName());
            TextView top = findViewById(resourceId);
            String top1_text = leaderboard_names[i]+ "-"+ leaderboard_scores[i];
            top.setText(top1_text);
        }
        //back button
        Button back = findViewById(R.id.back_button);
        back.setOnClickListener(view -> {
            Intent home = new Intent(getApplicationContext(), MainPage.class);
            startActivity(home);
        });
    }
}