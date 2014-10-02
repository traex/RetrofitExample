package com.andexert.retrofitexample.rest.service;

import com.andexert.retrofitexample.rest.model.ApiResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public interface WeatherService
{
    @GET("/data/2.5/weather")
    public void getWeather(@Query("q") String strCity, Callback<ApiResponse> callback);
}
