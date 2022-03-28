package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    Button E_button;
    Button M_button;
    Button H_button;
    Button Leader_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        E_button = findViewById(R.id.button3);
        E_button.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent i = new Intent(getApplicationContext(), InputPage.class);
                                            i.putExtra("Mode", "easy");
                                            startActivity(i);
                                        }
                                    }
        );
        M_button= findViewById(R.id.button4);
        M_button.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent i = new Intent(getApplicationContext(), InputPage.class);
                                            i.putExtra("Mode", "normal");
                                            startActivity(i);
                                        }
                                    }
        );
        H_button= findViewById(R.id.button5);
        H_button.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent i = new Intent(getApplicationContext(), InputPage.class);
                                            i.putExtra("Mode", "hard");
                                            startActivity(i);
                                        }
                                    }
        );
        Leader_button= findViewById(R.id.button6);
        Leader_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LeaderboardsPage.class);
                startActivity(i);
            }
        });
    }

}