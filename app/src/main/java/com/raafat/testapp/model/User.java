package com.raafat.testapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.raafat.testapp.BR;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Raafat Alhoumaidy on 3/18/2019 @3:16 PM.
 */
public class User extends BaseObservable {

    @SerializedName("_id")
    private String id;
    @SerializedName("about")
    private String about;
    @SerializedName("address")
    private String address;
    @SerializedName("age")
    private int age;
    @SerializedName("email")
    private String email;
    @SerializedName("gallery")
    private List<String> gallery;
    @SerializedName("phone")
    private String phone;
    @SerializedName("picture")
    private String profileImage;
    @SerializedName("tags")
    private List<String> tags;
    @SerializedName("friends")
    private List<Friend> friends;
    @SerializedName("name")
    private Name name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Bindable
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        notifyPropertyChanged(BR.profileImage);

    }

    @Bindable
    public String getTagsStr() {
        String res = "";
        for (String str : tags) {
            res += "#" + str + " ";
        }
        return res;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    @Bindable
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }


}
