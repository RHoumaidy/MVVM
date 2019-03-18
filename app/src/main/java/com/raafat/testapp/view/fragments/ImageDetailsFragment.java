package com.raafat.testapp.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raafat.testapp.R;
import com.raafat.testapp.databinding.FragmentImageDetailsBinding;
import com.raafat.testapp.model.User;

/**
 * Created by Raafat Alhoumaidy on 3/19/2019 @3:09 AM.
 */
public class ImageDetailsFragment extends Fragment {

    private User user;
    private int imgIdx;
    private FragmentImageDetailsBinding binding;

    public ImageDetailsFragment setUser(User user) {
        this.user = user;
        return this;
    }

    public ImageDetailsFragment setImgIdx(int idx) {
        this.imgIdx = idx;
        return this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_details, container, false);
        binding.setUser(user);
        binding.setImgIdx(imgIdx);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
