package com.raafat.testapp.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.raafat.testapp.model.User;
import com.raafat.testapp.R;
import com.raafat.testapp.view.callbacks.OnUserClickListner;
import com.raafat.testapp.databinding.ItemUserLayoutBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raafat Alhoumaidy on 3/18/2019 @4:41 PM.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ItemViewHolder> {

    private List<User> data = new ArrayList<>();
    private OnUserClickListner onUserClickListner;

    public void setOnUserClickListner(OnUserClickListner onUserClickListner) {
        this.onUserClickListner = onUserClickListner;
    }

    public void setData(final List<User> usersList) {
        if (this.data.size() ==  0) {
            this.data.addAll(usersList);
            notifyItemRangeInserted(0, usersList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return UserAdapter.this.data.size();
                }

                @Override
                public int getNewListSize() {
                    return usersList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return UserAdapter.this.data.get(oldItemPosition).getId().equals(
                            usersList.get(newItemPosition).getId());
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    User user = usersList.get(newItemPosition);
                    User old = usersList.get(oldItemPosition);
                    return user.getId().equals(old.getId());
                }
            });
            this.data = usersList;
            result.dispatchUpdatesTo(this);
        }
    }


    public UserAdapter(OnUserClickListner onUserClickListner) {
        this.onUserClickListner = onUserClickListner;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemUserLayoutBinding itemUserLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_user_layout, viewGroup, false);
        itemUserLayoutBinding.setCallback(onUserClickListner);

        return new ItemViewHolder(itemUserLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int i) {
        viewHolder.bind(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemUserLayoutBinding itemUserLayoutBinding;

        public ItemViewHolder(ItemUserLayoutBinding itemUserLayoutBinding) {
            super(itemUserLayoutBinding.getRoot());
            this.itemUserLayoutBinding = itemUserLayoutBinding;
        }

        public void bind(User user) {
            itemUserLayoutBinding.setUser(user);
            itemUserLayoutBinding.executePendingBindings();
        }
    }
}
