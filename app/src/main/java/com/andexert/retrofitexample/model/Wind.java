package com.andexert.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class Wind implements Serializable
{
    private static final long serialVersionUID = -3224791673461604480L;

    @SerializedName("speed")
    private Double speed;

    public Double getSpeed()
    {
        return speed;
    }
}
