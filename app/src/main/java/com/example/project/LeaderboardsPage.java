package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LeaderboardsPage extends AppCompatActivity {
    StoreData store_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards_page);
        String[] leaderboard_names = store_data.getNames();
        String[] leaderboard_scores = store_data.getScores();
        for (int i = 0; i< leaderboard_names.length; i++){
            String text_id = "score_top"+(i+1);
            int resourceId = this.getResources().getIdentifier(text_id,"string", this.getPackageName());
            TextView top = findViewById(resourceId);
            String top1_text = leaderboard_names[i]+ "-"+ leaderboard_scores[i];
            top.setText(top1_text);
        }
    }
}