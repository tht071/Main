package com.example.nongsan.data.remote.entity;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("image")
    public String image;
}
