package com.example.project;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainPage extends AppCompatActivity {
    Button E_button;
    Button M_button;
    Button H_button;
    Button Leader_button;
    String CITY = "London,UK";
    String API = "13ea03b9a160703f897b5d992b6600e5";

    TextView addressTxt, statusTxt, tempTxt, windTxt, pressureTxt, humidityTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        E_button = findViewById(R.id.button3);

        addressTxt = findViewById(R.id.cityText);

        statusTxt = findViewById(R.id.condDescr);
        tempTxt = findViewById(R.id.temp);

        windTxt = findViewById(R.id.windSpeed);
        pressureTxt = findViewById(R.id.press);
        humidityTxt = findViewById(R.id.hum);
        new weatherTask().execute();


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
    class weatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&units=metric&appid=" + API);
            return response;
        }

        @Override
        protected void onPostExecute(String result) {


            try {
                JSONObject jsonObj = new JSONObject(result);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONObject sys = jsonObj.getJSONObject("sys");
                JSONObject wind = jsonObj.getJSONObject("wind");
                JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

                Long updatedAt = jsonObj.getLong("dt");
                String updatedAtText = "Updated at: " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
                String temp = main.getString("temp") + "°C";
                String tempMin = "Min Temp: " + main.getString("temp_min") + "°C";
                String tempMax = "Max Temp: " + main.getString("temp_max") + "°C";
                String pressure = main.getString("pressure");
                String humidity = main.getString("humidity");

                Long sunrise = sys.getLong("sunrise");
                Long sunset = sys.getLong("sunset");
                String windSpeed = wind.getString("speed");
                String weatherDescription = weather.getString("description");

                String address = jsonObj.getString("name") + ", " + sys.getString("country");

                addressTxt.setText(address);
                statusTxt.setText(weatherDescription.toUpperCase());
                tempTxt.setText(temp);
                windTxt.setText(windSpeed);
                pressureTxt.setText(pressure);
                humidityTxt.setText(humidity);


            } catch (JSONException e) {
            }

        }
    }


}