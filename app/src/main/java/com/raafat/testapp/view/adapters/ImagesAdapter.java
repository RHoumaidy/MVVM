package com.raafat.testapp.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.raafat.testapp.R;
import com.raafat.testapp.databinding.ItemGalleryLayoutBinding;
import com.raafat.testapp.model.User;
import com.raafat.testapp.view.callbacks.OnGalleryItemClickListner;

import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.MyViewHolder> {

    private List<String> data;
    private LayoutInflater layoutInflater;
    private OnGalleryItemClickListner listener;
    private User user;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ItemGalleryLayoutBinding binding;

        public MyViewHolder(final ItemGalleryLayoutBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


    public ImagesAdapter(List<String> data, OnGalleryItemClickListner listener,User user) {
        this.data = data;
        this.listener = listener;
        this.user = user;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemGalleryLayoutBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_gallery_layout, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.binding.setUser(user);
        holder.binding.setImgIdx(position);
        holder.binding.setCallback(listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
