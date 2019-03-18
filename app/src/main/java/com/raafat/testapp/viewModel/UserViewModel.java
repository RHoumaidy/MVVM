package com.raafat.testapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.raafat.testapp.model.User;
import com.raafat.testapp.repository.UsersRepository;

/**
 * Created by Raafat Alhoumaidy on 3/18/2019 @5:43 PM.
 */
public class UserViewModel extends ViewModel {

    private LiveData<User> userLiveData;

    public UserViewModel() {

        userLiveData = UsersRepository.getInstance().getUser(0);
    }
}
