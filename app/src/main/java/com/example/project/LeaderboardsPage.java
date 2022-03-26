package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LeaderboardsPage extends AppCompatActivity {

    public LeaderboardsPage() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards_page);
    }
    private String[] leaderboard_names;
    private String[] leaderboard_scores;


    public void setLeaderboardnames(String[] names){
        this.leaderboard_names = names;
    }
    public String[] getLeaderboard_names(){
        return this.leaderboard_names;
    }
    public void setLeaderboardscores(String[] scores){
        this.leaderboard_scores = scores;
    }
    public String[] getLeaderboardscores(){
        return this.leaderboard_scores;
    }
    public void leaderboardscores(){
        TextView score1 = findViewById(R.id.score1);
        String score1_text = leaderboard_names[0]+ "-"+ leaderboard_scores[0];
        score1.setText(score1_text);

        TextView score2 = findViewById(R.id.score2);
        String score2_text = leaderboard_names[1]+ "-"+ leaderboard_scores[1];
        score2.setText(score2_text);

        TextView score3 = findViewById(R.id.score3);
        String score3_text = leaderboard_names[2]+ "-"+ leaderboard_scores[2];
        score3.setText(score3_text);

        TextView score4 = findViewById(R.id.score4);
        String score4_text = leaderboard_names[3]+ "-"+ leaderboard_scores[3];
        score4.setText(score4_text);

        TextView score5 = findViewById(R.id.score5);
        String score5_text = leaderboard_names[4]+ "-"+ leaderboard_scores[4];
        score5.setText(score5_text);

        TextView score6 = findViewById(R.id.score6);
        String score6_text = leaderboard_names[5]+ "-"+ leaderboard_scores[5];
        score6.setText(score6_text);

        TextView score7 = findViewById(R.id.score7);
        String score7_text = leaderboard_names[6]+ "-"+ leaderboard_scores[6];
        score7.setText(score7_text);

        TextView score8 = findViewById(R.id.score8);
        String score8_text = leaderboard_names[7]+ "-"+ leaderboard_scores[7];
        score8.setText(score8_text);

        TextView score9 = findViewById(R.id.score9);
        String score9_text = leaderboard_names[8]+ "-"+ leaderboard_scores[8];
        score9.setText(score9_text);

        TextView score10 = findViewById(R.id.score10);
        String score10_text = leaderboard_names[9]+ "-"+ leaderboard_scores[9];
        score10.setText(score10_text);

        TextView score11 = findViewById(R.id.score11);
        String score11_text = leaderboard_names[10]+ "-"+ leaderboard_scores[10];
        score11.setText(score11_text);

        TextView score12 = findViewById(R.id.score12);
        String score12_text = leaderboard_names[11]+ "-"+ leaderboard_scores[11];
        score12.setText(score12_text);

        TextView score13 = findViewById(R.id.score13);
        String score13_text = leaderboard_names[12]+ "-"+ leaderboard_scores[12];
        score13.setText(score13_text);

        TextView score14 = findViewById(R.id.score14);
        String score14_text = leaderboard_names[13]+ "-"+ leaderboard_scores[13];
        score14.setText(score14_text);

        TextView score15 = findViewById(R.id.score15);
        String score15_text = leaderboard_names[14]+ "-"+ leaderboard_scores[14];
        score15.setText(score15_text);

        TextView score16 = findViewById(R.id.score16);
        String score16_text = leaderboard_names[15]+ "-"+ leaderboard_scores[15];
        score16.setText(score16_text);

        TextView score17 = findViewById(R.id.score17);
        String score17_text = leaderboard_names[16]+ "-"+ leaderboard_scores[16];
        score17.setText(score17_text);

        TextView score18 = findViewById(R.id.score18);
        String score18_text = leaderboard_names[17]+ "-"+ leaderboard_scores[17];
        score18.setText(score18_text);

        TextView score19 = findViewById(R.id.score19);
        String score19_text = leaderboard_names[18]+ "-"+ leaderboard_scores[18];
        score19.setText(score19_text);

        TextView score20 = findViewById(R.id.score20);
        String score20_text = leaderboard_names[19]+ "-"+ leaderboard_scores[19];
        score20.setText(score20_text);
    }
}