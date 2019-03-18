package com.raafat.testapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Raafat Alhoumaidy on 3/18/2019 @3:28 PM.
 */
public class Name extends BaseObservable {

    @SerializedName("first")
    private String first;
    @SerializedName("last")
    private String last;

    @Bindable
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Bindable
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
