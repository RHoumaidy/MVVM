package com.raafat.testapp.view.fragments;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.raafat.testapp.model.User;
import com.raafat.testapp.R;
import com.raafat.testapp.view.adapters.UserAdapter;
import com.raafat.testapp.view.callbacks.OnUserClickListner;
import com.raafat.testapp.viewModel.UsersListViewModel;
import com.raafat.testapp.databinding.FragmentUsersListBinding;

import java.util.List;

/**
 * Created by Raafat Alhoumaidy on 3/18/2019 @6:04 PM.
 */
public class UserListFragment extends Fragment {

    private UserAdapter userAdapter;
    private FragmentUsersListBinding binding;
    private OnUserClickListner onUserClickListner;
    private UsersListViewModel viewModel;

    public void setOnUserClickListner(OnUserClickListner onUserClickListner) {
        this.onUserClickListner = onUserClickListner;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider.NewInstanceFactory().create(UsersListViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_users_list, container, false);
        userAdapter = new UserAdapter(onUserClickListner);
        binding.setIsLoading(true);
        binding.usersRV.setAdapter(userAdapter);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        observeViewModel(viewModel);
    }

    private void observeViewModel(UsersListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getUsersListObservable().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                if (users != null) {
                    binding.setIsLoading(false);
                    userAdapter.setData(users);
                }
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
