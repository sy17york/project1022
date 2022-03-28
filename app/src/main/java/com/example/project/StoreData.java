package com.example.project;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class StoreData extends AppCompatActivity {
    private int score_length;

    public void putScores(String[] save_high_scores){
        SharedPreferences put_scores = getSharedPreferences("TopScores", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = put_scores.edit();
        for (int i = 0; i<save_high_scores.length; i++){
            String num = String.valueOf(i+1);
            num = "top"+i;
            editor.putString(num, save_high_scores[i]);
            editor.apply();
        }
    }
    public void length_of_scores(int num){
        this.score_length = num;

    }
    public String[] getScores(){
        SharedPreferences get_scores = getApplicationContext().getSharedPreferences("TopScores", Context.MODE_PRIVATE);
        String[] scores = new String[this.score_length];
        for (int i = 0; i<this.score_length; i++){
            String player_scores = "top" + String.valueOf(i+1);
            scores[i] = get_scores.getString(player_scores, "");
        }
        return scores;
    }
    public void putCurrentScore(int score){
        SharedPreferences current = getSharedPreferences("current_score", Context.MODE_PRIVATE);
        SharedPreferences.Editor current_score_edit = current.edit();
        current_score_edit.putInt("user_current_score", score);
        current_score_edit.apply();
    }
    public int getCurrentScore(){
        SharedPreferences score = getApplicationContext().getSharedPreferences("current_score", Context.MODE_PRIVATE);
        return score.getInt("user_current_score", 0);
    }

}
