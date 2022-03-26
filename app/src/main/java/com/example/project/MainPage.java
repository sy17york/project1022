package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainPage extends AppCompatActivity {
//test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }
    public void easySelected(View v){
        RunGame game = new RunGame();
        game.setMode("easy");
        Intent intent = new Intent(MainPage.this, InputPage.class);
        startActivity(intent);
    }
    public void mediumSelected(View v){
        RunGame game = new RunGame();
        game.setMode("medium");
        Intent intent = new Intent(MainPage.this, InputPage.class);
        startActivity(intent);
    }
    public void hardSelected(View v){
        RunGame game = new RunGame();
        game.setMode("hard");
        Intent intent = new Intent(MainPage.this, InputPage.class);
        startActivity(intent);
    }
    public void leaderboardsSelected(View v){
        Intent intent = new Intent(MainPage.this, LeaderboardsPage.class);
        startActivity(intent);
    }
}