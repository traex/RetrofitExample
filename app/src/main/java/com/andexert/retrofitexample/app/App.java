package com.andexert.retrofitexample.app;

import android.app.Application;

import com.andexert.retrofitexample.rest.RestClient;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class App extends Application
{
    private static RestClient restClient;

    @Override
    public void onCreate()
    {
        super.onCreate();

        restClient = new RestClient();
    }

    public static RestClient getRestClient()
    {
        return restClient;
    }
}
