package com.raafat.testapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Raafat Alhoumaidy on 3/18/2019 @3:27 PM.
 */
public class Friend {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
