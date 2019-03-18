package com.raafat.testapp.view.activites;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.raafat.testapp.R;
import com.raafat.testapp.model.User;
import com.raafat.testapp.view.callbacks.OnGalleryItemClickListner;
import com.raafat.testapp.view.callbacks.OnUserClickListner;
import com.raafat.testapp.view.fragments.ImageDetailsFragment;
import com.raafat.testapp.view.fragments.UserDetailsFragment;
import com.raafat.testapp.view.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity {

    private UserListFragment userListFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            userListFragment = new UserListFragment();
            userListFragment.setOnUserClickListner(onUserClickListner);
            fragmentManager.beginTransaction()
                    .add(R.id.mainContainer, userListFragment).commit();
        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if (fragmentManager.getBackStackEntryCount() > 0)
                super.onBackPressed();
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            return true;
        }
        return false;
    }

    private OnUserClickListner onUserClickListner = new OnUserClickListner() {
        @Override
        public void onClick(User user) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            UserDetailsFragment userDetailsFragment = new UserDetailsFragment()
                    .setUser(user)
                    .setOnGalleryItemClickListner(onGalleryItemClickListner);
            fragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, userDetailsFragment)
                    .addToBackStack("userDetails")
                    .commit();
        }
    };

    private OnGalleryItemClickListner onGalleryItemClickListner = new OnGalleryItemClickListner() {
        @Override
        public void onClick(User user,int imgIdx) {
            ImageDetailsFragment imageDetailsFragment = new ImageDetailsFragment()
                    .setUser(user)
                    .setImgIdx(imgIdx);
            fragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, imageDetailsFragment)
                    .addToBackStack("imageDetails")
                    .commit();
        }
    };

}
