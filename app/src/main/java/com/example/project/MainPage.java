package com.example.project;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

public class MainPage extends AppCompatActivity {
    Button E_button;
    Button M_button;
    Button H_button;
    Button Leader_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        String city = "London,UK";
        MainPage.JSONWeatherTask task = new MainPage.JSONWeatherTask();
        task.execute(new String[]{city});
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
    private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... params) {
            Weather weather = new Weather();
            String data = ( (new WeatherHTTP()).getWeatherData(params[0]));
            try {
                weather = JSONparser.getWeather(data);
                weather.iconData = ( (new WeatherHTTP()).getImage(weather.currentCondition.getIcon()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return weather;

        }
        @Override
        protected void onPostExecute(Weather weather) {
            TextView cityText = (TextView) findViewById(R.id.cityText);
            TextView condDescr = (TextView) findViewById(R.id.condDescr);
            TextView temp = (TextView) findViewById(R.id.temp);
            TextView hum = (TextView) findViewById(R.id.hum);
            TextView press = (TextView) findViewById(R.id.press);
            TextView windSpeed = (TextView) findViewById(R.id.windSpeed);
            TextView windDeg = (TextView) findViewById(R.id.windDeg);
            super.onPostExecute(weather);
            cityText.setText(weather.location.getCity() + "," + weather.location.getCountry());
            condDescr.setText(weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescr() + ")");
            temp.setText("" + Math.round((weather.temperature.getTemp() - 273.15)) + "�C");
            hum.setText("" + weather.currentCondition.getHumidity() + "%");
            press.setText("" + weather.currentCondition.getPressure() + " hPa");
            windSpeed.setText("" + weather.wind.getSpeed() + " mps");
            windDeg.setText("" + weather.wind.getDeg() + "�");

        }
    }

}