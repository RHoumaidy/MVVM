package com.raafat.testapp.view.fragments;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raafat.testapp.R;
import com.raafat.testapp.databinding.FragmentUserDetailsBinding;
import com.raafat.testapp.helpers.GridSpacingItemDecoration;
import com.raafat.testapp.model.User;
import com.raafat.testapp.view.adapters.ImagesAdapter;
import com.raafat.testapp.view.callbacks.OnGalleryItemClickListner;

/**
 * Created by Raafat Alhoumaidy on 3/19/2019 @12:18 AM.
 */
public class UserDetailsFragment extends Fragment {

    private ImagesAdapter imagesAdapter;
    private FragmentUserDetailsBinding binding;
    private OnGalleryItemClickListner onGalleryItemClickListner;
    private User user;

    public UserDetailsFragment setOnGalleryItemClickListner(OnGalleryItemClickListner onGalleryItemClickListner) {
        this.onGalleryItemClickListner = onGalleryItemClickListner;
        return this;
    }

    public UserDetailsFragment setUser(User user){
        this.user = user;
        return this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_details,container,false);

        return binding.getRoot();
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setUser(user);
        imagesAdapter = new ImagesAdapter(user.getGallery(),onGalleryItemClickListner,user);
        binding.imagesrv.setItemAnimator(new DefaultItemAnimator());
        binding.imagesrv.setLayoutManager(new GridLayoutManager(getContext(),3,LinearLayoutManager.VERTICAL,false));
        binding.imagesrv.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(2), true));
        binding.imagesrv.setAdapter(imagesAdapter);

    }
}
