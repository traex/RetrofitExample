package com.andexert.retrofitexample.rest;

import com.andexert.retrofitexample.rest.service.WeatherService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class RestClient
{
    private static final String BASE_URL = "http://api.openweathermap.org/";
    private WeatherService apiService;

    public RestClient()
    {
        Gson gson = new Gson();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        apiService = restAdapter.create(WeatherService.class);
    }

    public WeatherService getWeatherService()
    {
        return apiService;
    }
}
