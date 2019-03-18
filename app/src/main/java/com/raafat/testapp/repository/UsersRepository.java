package com.raafat.testapp.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.raafat.testapp.model.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Raafat Alhoumaidy on 3/18/2019 @3:38 PM.
 */
public class UsersRepository {

    private UsersService usersService;
    private static UsersRepository usersRepository;
    private MutableLiveData<List<User>> usersList = new MutableLiveData<>();

    private UsersRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UsersService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        usersService = retrofit.create(UsersService.class);
    }

    public synchronized static UsersRepository getInstance() {
        if (usersRepository == null) {
            usersRepository = new UsersRepository();

        }
        return usersRepository;
    }

    public LiveData<List<User>> getUsersList() {

        usersService.getUsersList().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                List<User> tmp = new ArrayList<>();
                JsonObject responseBody = response.body();
                List<String> keys = new ArrayList<>(responseBody.keySet());
                for (int i = 0; i < responseBody.size(); ++i) {
                    try {
                        Type userType = new TypeToken<User>() {
                        }.getType();
                        User user = new Gson().fromJson(responseBody.get(keys.get(i)), userType);
                        user.setProfileImage("https://picsum.photos/200/300/?image=" + new Random().nextInt(1000));
                        for (int j = 0; j < user.getGallery().size(); ++j) {
                            user.getGallery().set(j, "https://picsum.photos/800/900/?image=" + new Random().nextInt(1000));

                        }
                        tmp.add(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                usersList.setValue(tmp);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

        return usersList;
    }

    public LiveData<User> getUser(int pos) {
        MutableLiveData<User> res = new MutableLiveData<>();
        res.setValue(usersList.getValue().get(pos));
        return res;
    }
}
