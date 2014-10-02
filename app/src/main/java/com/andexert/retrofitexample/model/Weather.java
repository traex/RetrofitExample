package com.andexert.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class Weather implements Serializable
{
    private static final long serialVersionUID = -6881496468757538525L;

    @SerializedName("description")
    private String strDesc;

    @SerializedName("icon")
    private String strIconName;

    public String getStrDesc()
    {
        return strDesc;
    }

    public void setStrDesc(String strDesc)
    {
        this.strDesc = strDesc;
    }

    public String getStrIconName()
    {
        return strIconName;
    }

    public void setStrIconName(String strIconName)
    {
        this.strIconName = strIconName;
    }
}
