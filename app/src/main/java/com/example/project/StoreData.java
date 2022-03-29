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
            if (save_high_scores[i]!=null) {
                String num = "top"+ (i + 1);
                editor.putString(num, save_high_scores[i]);
                editor.apply();
            }
        }
    }
    public void putNames(String[] names){
        SharedPreferences put_names = getSharedPreferences("TopScores", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = put_names.edit();
        for (int i = 0; i<names.length; i++){
            if (names[i]!=null) {
                String num = "name"+ (i + 1);
                editor.putString(num, names[i]);
                editor.apply();
            }
        }
    }
    public String[] getNames() {
        SharedPreferences get_names = getApplicationContext().getSharedPreferences("TopScores", Context.MODE_PRIVATE);
        String[] names = new String[this.score_length];
        for (int i = 0; i < this.score_length; i++) {
            String player_scores = "name" + (i + 1);
            names[i] = get_names.getString(player_scores, "");
        }

        return names;
    }
    public void length_of_scores(int num){
        SharedPreferences get_length = getSharedPreferences("ScoreAmount", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = get_length.edit();
        editor.putInt("amount", num);
        editor.apply();

    }
    public int get_length_scores(){
        SharedPreferences amount_scores = getSharedPreferences("ScoreAmount", Context.MODE_PRIVATE);
        this.score_length = amount_scores.getInt("amount", 0);
        return this.score_length;
    }
    public String[] getScores(){
        SharedPreferences get_scores = getApplicationContext().getSharedPreferences("TopScores", Context.MODE_PRIVATE);
        String[] scores = new String[this.score_length];
        for (int i = 0; i<this.score_length; i++){
            String player_scores = "top" + (i + 1);
            scores[i] = get_scores.getString(player_scores, "");
        }
        return scores;
    }

}
