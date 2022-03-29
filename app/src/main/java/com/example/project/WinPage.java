package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class WinPage extends AppCompatActivity {
    private String winner_name;
    StoreData store_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_page);
        //intent
        Intent intent = getIntent();
        String score = intent.getStringExtra("Score");
        //win score display
        TextView textView = findViewById(R.id.winscore_display);
        textView.setText(score);

        //If new score
        if (store_data.get_length_scores()==0){
            showNewScore();
            String[] first_score = new String[1];
            String[] first_name = new String[1];
            first_score[0] = String.valueOf(score);
            first_name[0] = winner_name;
            store_data.putScores(first_score);
            store_data.putNames(first_name);
            store_data.length_of_scores(1);
        }else{
            String[] game_scores = store_data.getScores();
            String[] score_names = store_data.getNames();
            String[] score_arr = new String[20];
            String[] name_arr = new String[20];
            if (game_scores.length<20){
                for(int i = 0;i<game_scores.length;i++){
                    score_arr[i] = score_names[i];
                    name_arr[i] = score_names[i];
                }
                game_scores = score_arr;
                score_names = name_arr;
            }

            for (int i = 0; i<game_scores.length; i++){
                if (Integer.parseInt(score) > Integer.parseInt(game_scores[i]) || score_arr[i] == null){
                    store_data.length_of_scores(game_scores.length+1);
                    showNewScore();
                    game_scores[i] = score;
                    score_names[i] = this.winner_name;
                    store_data.putNames(score_names);
                    store_data.putScores(game_scores);
                    break;
                }
            }

        }

        //Home and retry button
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


    private void showNewScore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(WinPage.this);
        builder.setTitle("NEW Top Score Enter Name Below!");
        final EditText input = new EditText(this);
        builder.setView(input);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                winner_name = input.getText().toString();
                // Do something with value!
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });
        builder.show();
    }
}