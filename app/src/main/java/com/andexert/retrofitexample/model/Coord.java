package com.andexert.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class Coord implements Serializable
{
    private static final long serialVersionUID = -6230665672541697131L;

    @SerializedName("lon")
    private Double longitude;

    @SerializedName("lat")
    private Double latitude;

    public Double getLongitude()
    {
        return longitude;
    }

    public Double getLatitude()
    {
        return latitude;
    }
}
