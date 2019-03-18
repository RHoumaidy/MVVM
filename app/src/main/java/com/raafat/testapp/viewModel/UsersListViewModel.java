package com.raafat.testapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.raafat.testapp.model.User;
import com.raafat.testapp.repository.UsersRepository;

import java.util.List;

/**
 * Created by Raafat Alhoumaidy on 3/18/2019 @4:37 PM.
 */
public class UsersListViewModel extends ViewModel {

    private LiveData<List<User>> usersListObservable;

    public UsersListViewModel() {
        usersListObservable = UsersRepository.getInstance().getUsersList();
    }

    public LiveData<List<User>> getUsersListObservable() {
        return usersListObservable;
    }
}
