package com.raafat.testapp.repository;

import com.google.gson.JsonObject;
import com.raafat.testapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Raafat Alhoumaidy on 3/18/2019 @3:36 PM.
 */
public interface UsersService {

    public static final String API_URL  = "https://mock-database-dba0a.firebaseio.com/";

    @GET("users.json")
    Call<JsonObject> getUsersList();

}
