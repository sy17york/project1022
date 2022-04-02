package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;

public class LeaderboardsPage extends AppCompatActivity {
    StoreData store_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards_page);
        //getters for names and scores previous winners
        store_data = new StoreData();
        String[] display_scores = store_data.getScores(this, "AppScores");
        String[] display_names = store_data.getNames(this, "AppNames");
        for (int i = 0; i<display_scores.length; i++){
            if (display_scores[i]!=null){
                String score_id = "score"+(i+1);
                String display = (i+1)+"."+display_names[i] +"     |      "+display_scores[i];
                int resID = this.getResources().getIdentifier(score_id, "id", this.getPackageName());
                TextView text = findViewById(resID);
                text.setText(display);
            }

        }
        //back button
        Button back = findViewById(R.id.back_button);
        back.setOnClickListener(view -> {
            Intent home = new Intent(getApplicationContext(), MainPage.class);
            startActivity(home);
        });
    }

}