package com.andexert.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class Sys implements Serializable
{
    private static final long serialVersionUID = -7775280391757039482L;

    @SerializedName("country")
    private String strCountry;

    @SerializedName("sunrise")
    private Double sunriseTime;

    @SerializedName("sunset")
    private Double sunsetTime;

    public String getStrCountry()
    {
        return strCountry;
    }

    public void setStrCountry(String strCountry)
    {
        this.strCountry = strCountry;
    }

    public Double getSunriseTime()
    {
        return sunriseTime;
    }

    public Double getSunsetTime()
    {
        return sunsetTime;
    }
}
