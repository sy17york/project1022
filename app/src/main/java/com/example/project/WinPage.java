package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class WinPage extends AppCompatActivity {
    private String winner_name = "Default";
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

        store_data = new StoreData();
        //When the first ever score is entered a new array of 20 is added
        if(store_data.getScores(this, "AppScores").length==0){
            ShowNewScore();
            String[] new_score = new String[20];
            new_score[0] = score;
            store_data.putScores(this, new_score, "AppScores");
        }else { //After the first score, the rest is easy to add, comparing the Scores.
            String[] get_scores = store_data.getScores(this, "AppScores");
            int score_added = -1;
            for (int i = 0; i < get_scores.length; i++) {
                if (get_scores[i] == null) {
                    ShowAddScore(i);
                    get_scores[i] = score;
                    store_data.putScores(this, get_scores, "AppScores");
                    score_added = 1;
                    break;
                }
            }
            if (score_added == -1) {
                for (int i = 0; i < get_scores.length; i++) {
                    if(Integer.parseInt(score)>Integer.parseInt(get_scores[i])) {
                        ShowAddScore(i);
                        get_scores[i] = score;
                        store_data.putScores(this, get_scores, "AppScores");
                        break;
                    }
                }
            }
        }
        //display top 10
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

    //This method opens a dialog to add a score for first time scores
    private void ShowNewScore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(WinPage.this);
        builder.setTitle("NEW Top Score Enter Name Below!");
        EditText input = new EditText(this);
        builder.setCancelable(false);
        builder.setView(input);
        builder.setPositiveButton("Add Score", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                winner_name= input.getText().toString();
                String[] new_name = new String[20];
                new_name[0] = winner_name;
                store_data.putNames(WinPage.this, new_name, "AppNames");

            }
        });
        builder.show();
    }
    //This method opens a dialog to add a score for scores after the first time
    private void ShowAddScore(int index){
        AlertDialog.Builder builder = new AlertDialog.Builder(WinPage.this);
        builder.setTitle("NEW Top Score Enter Name Below!");
        EditText input = new EditText(this);
        builder.setCancelable(false);
        builder.setView(input);
        builder.setPositiveButton("Add Score", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                winner_name= input.getText().toString();
                String[] get_names = store_data.getNames(WinPage.this, "AppNames");
                get_names[index] = winner_name;
                store_data.putNames(WinPage.this, get_names, "AppNames");
            }
        });
        builder.show();
    }
}