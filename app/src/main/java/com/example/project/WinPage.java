package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
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


    private void showNewScore(){
        final Dialog dialog = new Dialog(WinPage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_new_score);

        ImageButton button = findViewById(R.id.add_scorebutton);
        button.setOnClickListener(view -> {
            EditText user_input = findViewById(R.id.name_input);
            this.winner_name = user_input.getText().toString();
            dialog.dismiss();
        });
    }
}