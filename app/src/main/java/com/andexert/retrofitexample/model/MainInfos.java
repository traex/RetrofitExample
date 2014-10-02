package com.andexert.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class MainInfos implements Serializable
{
    private static final long serialVersionUID = -3145681233419724222L;

    @SerializedName("temp")
    private Double temp;

    @SerializedName("pressure")
    private Double pressure;

    @SerializedName("humidity")
    private Double humidity;

    @SerializedName("temp_min")
    private Double tempMin;

    @SerializedName("temp_max")
    private Double tempMax;

    public Double getTemp()
    {
        return temp;
    }

    public Double getPressure()
    {
        return pressure;
    }

    public Double getHumidity()
    {
        return humidity;
    }

    public Double getTempMin()
    {
        return tempMin;
    }

    public Double getTempMax()
    {
        return tempMax;
    }
}
