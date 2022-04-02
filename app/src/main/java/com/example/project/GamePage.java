package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GamePage extends AppCompatActivity {
    EditText GuessInputNum;
    Button RunCheck;
    RunGame user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        Intent i = getIntent();
        String mode = i.getStringExtra("Mode");
        int expectedtries = Integer.parseInt(i.getStringExtra("Inputtries"));
        GuessInputNum = findViewById(R.id.editTextguessInputNum);
        RunCheck = findViewById(R.id.RunAndCheck);
        user = new RunGame();
        user.setMode(mode);
        user.setExpected_Tries(expectedtries);

        RunCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int guessednum = Integer.parseInt(GuessInputNum.getText().toString());

                switch (user.isNumberCorrect(guessednum)) {
                    case "win": {
                        String score = String.valueOf(user.getScore());
                        Intent intent = new Intent(getApplicationContext(), WinPage.class);
                        intent.putExtra("Score", score);
                        startActivity(intent);
                        break;
                    }
                    case "lose": {
                        Intent intent = new Intent(getApplicationContext(), LosePage.class);
                        intent.putExtra("Value", String.valueOf(user.getValue()));
                        startActivity(intent);
                        break;
                    }
                    case "too high": {
                        String str = "Tries: " + user.getActual_Tries();
                        ((TextView) findViewById(R.id.textViewguessedNum)).setText(str);
                        String str1 = guessednum + " too high";
                        ((TextView) findViewById(R.id.textViewshowLH)).setText(str1);
                        GuessInputNum.setText("");
                        break;
                    }
                    case "too low": {
                        String str = "Tries: " + user.getActual_Tries();
                        ((TextView) findViewById(R.id.textViewguessedNum)).setText(str);
                        String str1 = guessednum + " too low";
                        ((TextView) findViewById(R.id.textViewshowLH)).setText(str1);
                        GuessInputNum.setText("");
                        break;
                    }
                }
            }
        });

    }
}