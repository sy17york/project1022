package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LosePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_page);
        Intent intent = getIntent();
        String correct_number = intent.getStringExtra("Value");
    }

    private int losescoredisplay;
    private String[] winnernames;
    private String[] winnerscores;

    public int getLosescoredisplay(){
        return this.losescoredisplay;
    }
    public void setLosescoredisplay(int score){
        this.losescoredisplay = score;
    }
    public void setWinnernames(String[] names){
        this.winnernames = names;
    }
    public String[] getWinnernames(){
        return this.winnernames;
    }
    public void setWinnerscores(String[] scores){
        this.winnerscores = scores;
    }
    public String[] getWinnerscores(){
        return this.winnerscores;
    }
    public void lose_score(){
        TextView textView = findViewById(R.id.losescore_display);
        textView.setText(losescoredisplay);

        TextView top1 = findViewById(R.id.score_top1);
        String top1_text = winnernames[0]+ "-"+ winnerscores[0];
        top1.setText(top1_text);

        TextView top2 = findViewById(R.id.score_top2);
        String top2_text = winnernames[1]+ "-"+ winnerscores[1];
        top2.setText(top2_text);

        TextView top3 = findViewById(R.id.score_top3);
        String top3_text = winnernames[2]+ "-"+ winnerscores[2];
        top3.setText(top3_text);

        TextView top4 = findViewById(R.id.score_top4);
        String top4_text = winnernames[3]+ "-"+ winnerscores[3];
        top4.setText(top4_text);

        TextView top5 = findViewById(R.id.score_top5);
        String top5_text = winnernames[4]+ "-"+ winnerscores[4];
        top5.setText(top5_text);

        TextView top6 = findViewById(R.id.score_top6);
        String top6_text = winnernames[5]+ "-"+ winnerscores[5];
        top6.setText(top6_text);

        TextView top7 = findViewById(R.id.score_top7);
        String top7_text = winnernames[6]+ "-"+ winnerscores[6];
        top7.setText(top7_text);

        TextView top8 = findViewById(R.id.score_top8);
        String top8_text = winnernames[7]+ "-"+ winnerscores[7];
        top8.setText(top8_text);

        TextView top9 = findViewById(R.id.score_top9);
        String top9_text = winnernames[8]+ "-"+ winnerscores[8];
        top9.setText(top9_text);

        TextView top10 = findViewById(R.id.score_top10);
        String top10_text = winnernames[9]+ "-"+ winnerscores[9];
        top10.setText(top10_text);
    }

}