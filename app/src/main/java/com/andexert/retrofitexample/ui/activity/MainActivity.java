package com.andexert.retrofitexample.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.retrofitexample.R;
import com.andexert.retrofitexample.app.App;
import com.andexert.retrofitexample.rest.model.ApiResponse;
import com.squareup.picasso.Picasso;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {
    private final static String TAG = MainActivity.class.getSimpleName();

    @InjectView(R.id.activity_main_search)
    protected EditText searchEditText;

    @InjectView(R.id.activity_main_sys_country_value)
    protected TextView countryTextView;

    @InjectView(R.id.activity_main_sys_sunrise_value)
    protected TextView sunriseTextView;

    @InjectView(R.id.activity_main_sys_sunset_value)
    protected TextView sunsetTextView;

    @InjectView(R.id.activity_main_weather_icon)
    protected ImageView iconImageView;

    @InjectView(R.id.activity_main_weather_text)
    protected TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


    }

    @OnClick(R.id.activity_main_search_button)
    protected void onSearchClick()
    {
        if (!searchEditText.getText().toString().equals(""))
        {
            App.getRestClient().getWeatherService().getWeather(searchEditText.getText().toString(), new Callback<ApiResponse>()
            {
                @Override
                public void success(ApiResponse apiResponse, Response response)
                {
                    final Date sunriseDate = new Date(apiResponse.getSys().getSunriseTime() * 1000);
                    final Date sunsetDate = new Date(apiResponse.getSys().getSunsetTime() * 1000);
                    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh':'mm':'ss a");

                    getActionBar().setTitle(apiResponse.getStrCityName());
                    countryTextView.setText(apiResponse.getSys().getStrCountry());

                    if (!apiResponse.getWeather().isEmpty())
                    {
                        Picasso.with(MainActivity.this).load("http://openweathermap.org/img/w/" + apiResponse.getWeather().get(0).getStrIconName() + ".png").into(iconImageView);
                        weatherTextView.setText(apiResponse.getWeather().get(0).getStrDesc());
                    }

                    sunsetTextView.setText(simpleDateFormat.format(sunsetDate));
                    sunriseTextView.setText(simpleDateFormat.format(sunriseDate));

                    Log.e(TAG, "City name : " + apiResponse.getStrCityName());
                }

                @Override
                public void failure(RetrofitError error)
                {
                    Log.e(TAG, "Error : " + error.getMessage());
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
